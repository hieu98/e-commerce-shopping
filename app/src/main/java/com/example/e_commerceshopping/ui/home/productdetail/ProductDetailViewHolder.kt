package com.example.e_commerceshopping.ui.home.productdetail

import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.e_commerceshopping.databinding.ItemDetailProductBinding

class ProductDetailViewHolder(
    val binding: ItemDetailProductBinding
) : RecyclerView.ViewHolder(binding.root) {

    fun bindData(item: Int?){
        binding.imgDetailProduct.setImageResource(item!!)
    }
}