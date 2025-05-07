package org.ronil.library

import androidx.recyclerview.widget.RecyclerView
import androidx.viewbinding.ViewBinding

internal  class DataViewHolder<VB: ViewBinding>(val binding: VB) : RecyclerView.ViewHolder(binding.root)
