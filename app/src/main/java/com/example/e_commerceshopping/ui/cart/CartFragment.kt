package com.example.e_commerceshopping.ui.cart

import android.view.LayoutInflater
import android.view.ViewGroup
import com.example.e_commerceshopping.base.ui.BaseFragment
import com.example.e_commerceshopping.databinding.FragmentCartBinding
import com.example.e_commerceshopping.ui.MainActivity

class CartFragment : BaseFragment<FragmentCartBinding, MainActivity>() {
    override fun onInflateView(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): FragmentCartBinding = FragmentCartBinding.inflate(inflater)

    override fun setupView() {

    }

    override fun setupData() {

    }

}