package com.example.e_commerceshopping.ui.introduce.login

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.e_commerceshopping.R
import com.example.e_commerceshopping.base.ui.BaseFragment
import com.example.e_commerceshopping.databinding.FragmentSignUpBinding
import com.example.e_commerceshopping.extension.onClick
import com.example.e_commerceshopping.ui.MainActivity

class SignUpFragment : BaseFragment<FragmentSignUpBinding, MainActivity>(){
    override fun onInflateView(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): FragmentSignUpBinding = FragmentSignUpBinding.inflate(inflater)

    override fun setupView() {
        binding.apply {
            showBottomNav(false)

            btnBackLogin.onClick { popBackStack() }

            btnSignup.onClick {
                navigateTo(
                    R.id.action_signUpFragment_to_homeFragment,
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