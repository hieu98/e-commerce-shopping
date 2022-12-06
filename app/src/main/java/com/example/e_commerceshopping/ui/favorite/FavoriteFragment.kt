package com.example.e_commerceshopping.ui.favorite

import android.view.LayoutInflater
import android.view.ViewGroup
import com.example.e_commerceshopping.base.ui.BaseFragment
import com.example.e_commerceshopping.databinding.FragmentFavoriteBinding
import com.example.e_commerceshopping.ui.MainActivity

class FavoriteFragment : BaseFragment<FragmentFavoriteBinding, MainActivity>() {
    override fun onInflateView(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): FragmentFavoriteBinding = FragmentFavoriteBinding.inflate(inflater)

    override fun setupView() {

    }

    override fun setupData() {

    }

}