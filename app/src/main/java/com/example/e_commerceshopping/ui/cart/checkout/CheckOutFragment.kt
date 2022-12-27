package com.example.e_commerceshopping.ui.cart.checkout

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.e_commerceshopping.R
import com.example.e_commerceshopping.base.ui.BaseFragment
import com.example.e_commerceshopping.databinding.FragmentCheckOutBinding
import com.example.e_commerceshopping.extension.onClick
import com.example.e_commerceshopping.ui.MainActivity

class CheckOutFragment : BaseFragment<FragmentCheckOutBinding, MainActivity>() {
    override fun onInflateView(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): FragmentCheckOutBinding = FragmentCheckOutBinding.inflate(inflater)

    override fun setupView() {
        binding.apply {
            showBottomNav(false)
            header.tvTitle.setText(R.string.checkout)
            header.btnDelete.visibility = View.GONE

            header.ivNavigateBefore.onClick { popBackStack() }
            btnChange.onClick {

            }
        }
    }

    override fun setupData() {

    }

}