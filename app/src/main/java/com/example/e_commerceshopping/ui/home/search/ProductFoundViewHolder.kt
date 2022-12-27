package com.example.e_commerceshopping.ui.home.search

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.e_commerceshopping.extension.onClick

class ProductFoundViewHolder(
    itemView : View,
    val onClickProduct: ()-> Unit
) : RecyclerView.ViewHolder(itemView) {
    fun bindTo(item: ProductFoundGridItem){
        for (i in item.items.indices){
            val itemProduct = item.items[i]
            val img = itemView.findViewById<ImageView>(itemProduct.idPhoto)
            val title = itemView.findViewById<TextView>(itemProduct.idTitle)
            val price = itemView.findViewById<TextView>(itemProduct.idPrice)
            val root = itemView.findViewById<ConstraintLayout>(itemProduct.idRoot)

            Glide.with(itemView)
                .load(itemProduct.product?.image)
                .into(img)
            title.text = itemProduct.product?.name
            price.text = itemProduct.product?.price.toString()
            root.onClick {
                onClickProduct.invoke()
            }
        }
    }
}