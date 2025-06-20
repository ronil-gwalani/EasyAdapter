package org.ronil.library

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.viewbinding.ViewBinding


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


    @SuppressLint("NotifyDataSetChanged")
    internal fun addInitialItems(aList: List<T>) {
        mModelList.clear()
        mModelList.addAll(aList)
        notifyDataSetChanged()
    }

    fun getList(): ArrayList<T> {
        return mModelList
    }

    fun addItem(item: T) {
        mModelList.add(item)
        notifyItemInserted(mModelList.size - 1)
    }

    fun addMoreItems(aList: List<T>) {
        aList.forEach {
            mModelList.add(it)
            notifyItemInserted(mModelList.size - 1)
        }
    }


    fun removeItem(item: T) {
        val pos = mModelList.indexOf(item)
        if (pos != -1) {
            mModelList.remove(item)
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


