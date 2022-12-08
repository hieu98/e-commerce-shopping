package com.example.e_commerceshopping.ui.home

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.core.view.GravityCompat
import com.example.e_commerceshopping.R
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

        binding.apply {
            tabLayout.addTab(tabLayout.newTab().setText("Wearable"))
            tabLayout.addTab(tabLayout.newTab().setText("Laptops"))
            tabLayout.addTab(tabLayout.newTab().setText("Phones"))
            tabLayout.addTab(tabLayout.newTab().setText("Drones"))

            val adapter =

            appBar.btnNavigation.onClick {
                drawerLayout.openDrawer(GravityCompat.START)
            }

            btnLogout.onClick {
                popBackStack(
                    R.id.loginFragment,
                    false
                )
            }
        }
    }

    override fun setupData() {
    }

}