package com.example.e_commerceshopping.ui.home

import android.view.LayoutInflater
import android.view.ViewGroup
import com.example.e_commerceshopping.base.ui.BaseFragment
import com.example.e_commerceshopping.databinding.FragmentHomeBinding
import com.example.e_commerceshopping.ui.MainActivity

class HomeFragment : BaseFragment<FragmentHomeBinding, MainActivity>() {
    override fun onInflateView(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): FragmentHomeBinding = FragmentHomeBinding.inflate(inflater)

    override fun setupView() {
        TODO("Not yet implemented")
    }

    override fun setupData() {
        TODO("Not yet implemented")
    }

}