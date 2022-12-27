package com.example.e_commerceshopping.ui.favorite

import android.view.ViewGroup
import com.example.e_commerceshopping.R
import com.example.e_commerceshopping.base.ui.BaseAdapter
import com.example.e_commerceshopping.data.product.model.Product
import com.example.e_commerceshopping.databinding.ItemProductFoundBinding
import com.example.e_commerceshopping.extension.inflater
import com.example.e_commerceshopping.extension.loadImageFromUrl
import com.example.e_commerceshopping.extension.onClick
import okhttp3.internal.format

class FavoriteAdapter (
    data: List<Product>,
    private val clickProduct: (() -> Unit)? = null
) : BaseAdapter<Product, ItemProductFoundBinding>(data) {
    override fun onCreateVH(parent: ViewGroup, viewType: Int): ItemVH<ItemProductFoundBinding> =
        ItemProductFoundBinding.inflate(parent.inflater, parent, false).let(::ItemVH)

    override fun onBindVH(holder: ItemVH<ItemProductFoundBinding>, position: Int) {
        val product = currentList[position]

        holder.binding.apply {
            imgProduct.loadImageFromUrl(
                product.image
            )
            nameProduct.text = product.name
            priceProduct.text = format(this.root.context.getString(R.string.price), product.price!!)

            root.onClick {
                clickProduct?.invoke()
            }
        }
    }
}