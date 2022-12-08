package com.example.e_commerceshopping.ui.home

import android.view.ViewGroup
import com.example.e_commerceshopping.base.ui.BaseAdapter
import com.example.e_commerceshopping.data.product.model.Product
import com.example.e_commerceshopping.databinding.ItemProductBinding
import com.example.e_commerceshopping.extension.inflater

class ListProductAdapter(
    private val data: ArrayList<Product>
) : BaseAdapter<Product, ItemProductBinding>(data) {
    override fun onCreateVH(parent: ViewGroup, viewType: Int): ItemVH<ItemProductBinding> =
        ItemProductBinding.inflate(parent.inflater, parent, false).let(::ItemVH)

    override fun onBindVH(holder: ItemVH<ItemProductBinding>, position: Int) {
        holder.binding.apply {

        }
    }
}