package com.example.e_commerceshopping.ui.home

import android.view.LayoutInflater
import android.view.ViewGroup
import com.example.e_commerceshopping.base.ui.BaseFragment
import com.example.e_commerceshopping.databinding.ItemProductBinding
import com.example.e_commerceshopping.ui.MainActivity

class ListItemFragment : BaseFragment<ItemProductBinding, MainActivity>(){
    override fun onInflateView(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): ItemProductBinding = ItemProductBinding.inflate(inflater)

    override fun setupView() {

    }

    override fun setupData() {

    }
}