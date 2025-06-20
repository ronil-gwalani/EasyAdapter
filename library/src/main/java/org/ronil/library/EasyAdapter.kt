package org.ronil.library

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.LayoutManager
import androidx.viewbinding.ViewBinding

inline fun <reified VB : ViewBinding, M> RecyclerView.  setEasyAdapter(
    list: List<M>,
    manager: LayoutManager = LinearLayoutManager(context),
    crossinline onBindData: (VB, M, Int) -> Unit,
): EasyRecyclerAdapter<M, VB> {


    val myAdapter =
        object : EasyRecyclerAdapter<M, VB>() {
            override fun inflateBinding(inflater: LayoutInflater, parent: ViewGroup): VB {
                val method = VB::class.java.getMethod(
                    "inflate",
                    LayoutInflater::class.java,
                    ViewGroup::class.java,
                    Boolean::class.javaPrimitiveType
                )
                return method.invoke(null, inflater, parent, false) as VB
            }



            override fun onBindData(model: M, position: Int, dataBinding: VB) =
                onBindData(dataBinding, model, position)

        }

    this.layoutManager = manager
    this.adapter = myAdapter
    myAdapter.addInitialItems(list)
    return myAdapter

}
