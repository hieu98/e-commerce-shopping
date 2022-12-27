package com.example.e_commerceshopping.ui.home.search

import android.annotation.SuppressLint
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.e_commerceshopping.R
import com.example.e_commerceshopping.base.ui.BaseAdapter
import com.example.e_commerceshopping.data.product.model.Product
import com.example.e_commerceshopping.databinding.ItemProductBinding
import com.example.e_commerceshopping.databinding.ItemProductFoundBinding
import com.example.e_commerceshopping.extension.inflater
import com.example.e_commerceshopping.extension.loadImageFromUrl
import com.example.e_commerceshopping.extension.onClick
import okhttp3.internal.format

class SearchAdapter(
    val data: List<Product>,
    private val clickProduct: (() -> Unit)
) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    var items: MutableList<ProductFoundGridItem> = mutableListOf()
    private val itemsList = mutableListOf<Product>()

    @SuppressLint("NotifyDataSetChanged")
    fun addItem(products: List<Product>) {
        itemsList.clear()
        itemsList.addAll(products)
        val items1: MutableList<ProductFoundGridItem> = mutableListOf()
        val layouts = listOf(
            R.layout.item_product_found,
            R.layout.item_product_found2
        )
        for (i in itemsList.indices){
            val item = if (i%2 == 0) ProductFoundGridItem(layouts[0]) else ProductFoundGridItem(layouts[1])
            item.items.add(
                HolderItem(
                    itemsList[i],
                    R.id.img_product,
                    R.id.name_product,
                    R.id.price_product,
                    R.id.item_product
                )
            )
            items1.add(item)
        }
        this.items.addAll(items1)
        notifyDataSetChanged()
    }

    fun clear(){
        items.clear()
    }

    override fun getItemViewType(position: Int): Int {
        return items[position].layout
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(viewType, parent, false)
        return ProductFoundViewHolder (view, onClickProduct = clickProduct)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if(holder is ProductFoundViewHolder) holder.bindTo(items[position])
    }

    override fun getItemCount(): Int = items.size

}