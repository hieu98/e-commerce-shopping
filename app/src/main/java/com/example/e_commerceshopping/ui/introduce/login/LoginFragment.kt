package com.example.e_commerceshopping.ui.introduce.login

import android.view.LayoutInflater
import android.view.ViewGroup
import com.example.e_commerceshopping.R
import com.example.e_commerceshopping.base.ui.BaseFragment
import com.example.e_commerceshopping.databinding.FragmentLoginBinding
import com.example.e_commerceshopping.extension.onClick
import com.example.e_commerceshopping.ui.MainActivity

class LoginFragment : BaseFragment<FragmentLoginBinding, MainActivity>() {
    override fun onInflateView(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): FragmentLoginBinding = FragmentLoginBinding.inflate(inflater)

    override fun setupView() {
        binding.apply {
            showBottomNav(false)

            btnLogin.onClick {
                navigateTo(
                    R.id.action_loginFragment_to_homeFragment,
                    null,
                    R.id.nav_home,
                    false
                )
            }

            btnCreateAccoutn.onClick {
                navigateTo(
                    R.id.action_loginFragment_to_signUpFragment,
                    null,
                    R.id.nav_home,
                    false
                )
            }
        }
    }

    override fun setupData() {

    }

}