package com.example.e_commerceshopping.ui.home.search

import androidx.annotation.LayoutRes
import com.example.e_commerceshopping.data.product.model.Product

data class ProductFoundGridItem (
    @LayoutRes
    val layout: Int,
    var items: MutableList<HolderItem<Product?, Int, Int, Int, Int>> = mutableListOf(),
)

data class HolderItem<T, U, V, K, M>(
    val product: T? = null,
    val idPhoto: U,
    val idTitle: V,
    val idPrice: K,
    val idRoot: M,
)