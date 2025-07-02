package org.ronil.library

import android.annotation.SuppressLint
import android.os.Handler
import android.os.Looper
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import androidx.viewbinding.ViewBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.util.concurrent.Executors


abstract class EasyRecyclerAdapter<T, VB : ViewBinding> :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private val mModelList = ArrayList<T>()

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        onBindData(
            mModelList[position],
            position,
            (holder as DataViewHolder<VB>).binding
        )
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder =
        DataViewHolder(
            inflateBinding(LayoutInflater.from(parent.context), parent)
        )

    internal abstract fun inflateBinding(inflater: LayoutInflater, parent: ViewGroup): VB
    override fun getItemCount(): Int = mModelList.size
    internal abstract fun onBindData(model: T, position: Int, dataBinding: VB)

    // SOLUTION: Optional DiffUtil methods with default implementations
    internal open fun areItemsTheSame(oldItem: T, newItem: T): Boolean {
        // Default implementation - can be overridden for better performance
        return oldItem == newItem
    }

    internal open fun areContentsTheSame(oldItem: T, newItem: T): Boolean {
        // Default implementation - can be overridden for better performance
        return oldItem == newItem
    }

    internal open fun getChangePayload(oldItem: T, newItem: T): Any? = null

    // DiffUtil callback
    private inner class DiffCallback(
        private val oldList: List<T>,
        private val newList: List<T>
    ) : DiffUtil.Callback() {

        override fun getOldListSize(): Int = oldList.size
        override fun getNewListSize(): Int = newList.size

        override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
            return this@EasyRecyclerAdapter.areItemsTheSame(
                oldList[oldItemPosition],
                newList[newItemPosition]
            )
        }

        override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
            return this@EasyRecyclerAdapter.areContentsTheSame(
                oldList[oldItemPosition],
                newList[newItemPosition]
            )
        }

        override fun getChangePayload(oldItemPosition: Int, newItemPosition: Int): Any? {
            return this@EasyRecyclerAdapter.getChangePayload(
                oldList[oldItemPosition],
                newList[newItemPosition]
            )
        }
    }

    fun setNewList(newList: List<T>) {
        val diffCallback = DiffCallback(mModelList.toList(), newList)
        val diffResult = DiffUtil.calculateDiff(diffCallback)

        mModelList.clear()
        mModelList.addAll(newList)
        diffResult.dispatchUpdatesTo(this)
    }

    fun setNewListAsync(newList: List<T>, commitCallback: (() -> Unit)? = null) {
        val oldList = mModelList.toList()

        Executors.newSingleThreadExecutor().execute {
            val diffCallback = DiffCallback(oldList, newList)
            val diffResult = DiffUtil.calculateDiff(diffCallback)

            Handler(Looper.getMainLooper()).post {
                mModelList.clear()
                mModelList.addAll(newList)
                diffResult.dispatchUpdatesTo(this@EasyRecyclerAdapter)
                commitCallback?.invoke()
            }
        }
    }

    fun setNewListCoroutines(
        newList: List<T>,
        scope: CoroutineScope = GlobalScope,
        commitCallback: (() -> Unit)? = null
    ) {
        val oldList = mModelList.toList()

        scope.launch(Dispatchers.Default) {
            val diffCallback = DiffCallback(oldList, newList)
            val diffResult = DiffUtil.calculateDiff(diffCallback)

            withContext(Dispatchers.Main) {
                mModelList.clear()
                mModelList.addAll(newList)
                diffResult.dispatchUpdatesTo(this@EasyRecyclerAdapter)
                commitCallback?.invoke()
            }
        }
    }



    // All your existing methods remain unchanged
    @SuppressLint("NotifyDataSetChanged")
    internal fun addInitialItems(aList: List<T>) {
        mModelList.clear()
        mModelList.addAll(aList)
        notifyDataSetChanged()
    }

    fun getList(): ArrayList<T> = mModelList

    fun addItem(item: T) {
        mModelList.add(item)
        notifyItemInserted(mModelList.size - 1)
    }

    fun addMoreItems(aList: List<T>) {
        val startPosition = mModelList.size
        mModelList.addAll(aList)
        notifyItemRangeInserted(startPosition, aList.size)
    }

    fun removeItem(item: T) {
        val pos = mModelList.indexOf(item)
        if (pos != -1) {
            mModelList.removeAt(pos)
            notifyItemRemoved(pos)
        }
    }

    fun removeItem(pos: Int) {
        if (pos in 0 until mModelList.size) {
            mModelList.removeAt(pos)
            notifyItemRemoved(pos)
        }
    }

    internal fun getItem(position: Int): T = mModelList[position]

    @SuppressLint("NotifyDataSetChanged")
    fun clearList() {
        mModelList.clear()
        notifyDataSetChanged()
    }

    fun updateItem(item: T, position: Int) {
        if (position in 0 until mModelList.size) {
            mModelList[position] = item
            notifyItemChanged(position)
        }
    }

}