package com.example.e_commerceshopping.ui.user

import android.view.LayoutInflater
import android.view.ViewGroup
import com.example.e_commerceshopping.base.ui.BaseFragment
import com.example.e_commerceshopping.databinding.FragmentUserBinding
import com.example.e_commerceshopping.ui.MainActivity

class UserFragment : BaseFragment<FragmentUserBinding, MainActivity>() {
    override fun onInflateView(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): FragmentUserBinding = FragmentUserBinding.inflate(inflater)

    override fun setupView() {
        TODO("Not yet implemented")
    }

    override fun setupData() {
        TODO("Not yet implemented")
    }


}