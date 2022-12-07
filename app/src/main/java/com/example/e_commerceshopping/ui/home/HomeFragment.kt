package com.example.e_commerceshopping.ui.home

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.appcompat.app.ActionBarDrawerToggle
import com.example.e_commerceshopping.base.ui.BaseFragment
import com.example.e_commerceshopping.databinding.FragmentHomeBinding
import com.example.e_commerceshopping.extension.onClick
import com.example.e_commerceshopping.ui.MainActivity

class HomeFragment : BaseFragment<FragmentHomeBinding, MainActivity>() {
    override fun onInflateView(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): FragmentHomeBinding = FragmentHomeBinding.inflate(inflater)

    override fun setupView() {
        showBottomNav(true)

        binding.btnLogout.onClick {
            popBackStack()
        }
    }

    override fun setupData() {
    }

}