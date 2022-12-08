package com.example.e_commerceshopping.ui.home

import android.view.LayoutInflater
import android.view.ViewGroup
import com.example.e_commerceshopping.base.ui.BaseFragment
import com.example.e_commerceshopping.databinding.FragmentListItemBinding
import com.example.e_commerceshopping.ui.MainActivity

class ListItemFragment : BaseFragment<FragmentListItemBinding, MainActivity>(){
    override fun onInflateView(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): FragmentListItemBinding = FragmentListItemBinding.inflate(inflater)

    override fun setupView() {

    }

    override fun setupData() {

    }
}