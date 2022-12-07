package com.example.e_commerceshopping.ui.introduce.splash

import android.view.LayoutInflater
import android.view.ViewGroup
import com.example.e_commerceshopping.R
import com.example.e_commerceshopping.base.ui.BaseFragment
import com.example.e_commerceshopping.databinding.FragmentSplashBinding
import com.example.e_commerceshopping.extension.onClick
import com.example.e_commerceshopping.ui.MainActivity
import org.koin.android.ext.android.inject

class SplashFragment : BaseFragment<FragmentSplashBinding, MainActivity>() {
    private val viewModel: SplashViewModel by inject()

    override fun onInflateView(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): FragmentSplashBinding = FragmentSplashBinding.inflate(inflater)

    override fun setupView() {
        showBottomNav(false)

        binding.btnStart.onClick {
            navigateTo(
                R.id.action_splashFragment_to_loginFragment,
                null,
                R.id.nav_home,
                true
            )
        }
    }

    override fun setupData() {

    }


}