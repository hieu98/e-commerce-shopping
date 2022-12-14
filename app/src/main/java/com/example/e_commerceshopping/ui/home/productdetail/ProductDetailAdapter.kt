package com.example.e_commerceshopping.ui.home.productdetail

import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.e_commerceshopping.databinding.ItemDetailProductBinding
import com.example.e_commerceshopping.extension.inflater

class ProductDetailAdapter () : ListAdapter<Int, RecyclerView.ViewHolder>(
    object : DiffUtil.ItemCallback<Int>(){
        override fun areItemsTheSame(oldItem: Int, newItem: Int) = oldItem == newItem

        override fun areContentsTheSame(oldItem: Int, newItem: Int) =
            oldItem == newItem

    }
) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return ProductDetailViewHolder(
            ItemDetailProductBinding.inflate(
                parent.inflater,
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val item = getItem(position)
        (holder as ProductDetailViewHolder).bindData(item)
    }
}