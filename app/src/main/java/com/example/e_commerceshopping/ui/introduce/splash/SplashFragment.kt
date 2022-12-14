package com.example.e_commerceshopping.ui.introduce.splash

import android.view.LayoutInflater
import android.view.ViewGroup
import com.example.e_commerceshopping.R
import com.example.e_commerceshopping.base.ui.BaseFragment
import com.example.e_commerceshopping.databinding.FragmentSplashBinding
import com.example.e_commerceshopping.ui.MainActivity
import kotlinx.coroutines.delay
import org.koin.androidx.viewmodel.ext.android.viewModel

class SplashFragment : BaseFragment<FragmentSplashBinding, MainActivity>() {
    private val viewModel: SplashViewModel by viewModel()

    override fun onInflateView(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): FragmentSplashBinding = FragmentSplashBinding.inflate(inflater)

    override fun setupView() {
        showBottomNav(false)

        viewModel.isLogin.observe(viewLifecycleOwner){
            if (it){
                navigateTo(
                    R.id.action_splashFragment_to_homeFragment,
                    null,
                    R.id.nav_home,
                    true
                )
            }else {
                navigateTo(
                    R.id.action_splashFragment_to_loginFragment,
                    null,
                    R.id.nav_home,
                    true
                )
            }
        }
    }

    override fun setupData() {

    }


}