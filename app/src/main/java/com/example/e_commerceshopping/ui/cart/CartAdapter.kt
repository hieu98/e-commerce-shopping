package com.example.e_commerceshopping.ui.cart

import android.annotation.SuppressLint
import android.view.ViewGroup
import com.example.e_commerceshopping.R
import com.example.e_commerceshopping.base.ui.BaseAdapter
import com.example.e_commerceshopping.data.product.model.Product
import com.example.e_commerceshopping.databinding.ItemProductCartBinding
import com.example.e_commerceshopping.extension.inflater
import com.example.e_commerceshopping.extension.loadImageFromUrl
import com.example.e_commerceshopping.extension.onClick
import okhttp3.internal.format

class CartAdapter (
    private val data: List<Product>
) : BaseAdapter<Product, ItemProductCartBinding>(data) {
    override fun onCreateVH(parent: ViewGroup, viewType: Int): ItemVH<ItemProductCartBinding> =
        ItemProductCartBinding.inflate(parent.inflater, parent, false).let ( ::ItemVH )

    @SuppressLint("NotifyDataSetChanged")
    override fun onBindVH(holder: ItemVH<ItemProductCartBinding>, position: Int) {
        val product = currentList[position]

        holder.binding.apply {
            imgProduct.loadImageFromUrl(
                product.image
            )
            txtProductName.text = product.name
            txtProductPrice.text = format(this.root.context.getString(R.string.price), product.price!!)
            txtCount.text = product.quantity.toString()
            btnMinus.onClick {
                if (product.quantity!! > 0){
                    product.quantity = product.quantity?.minus(1)
                    notifyDataSetChanged()
                }

            }
            btnPlus.onClick {
                product.quantity = product.quantity?.plus(1)
                notifyDataSetChanged()
            }
        }
    }

}