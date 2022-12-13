package com.example.e_commerceshopping.ui.introduce.login

import android.view.LayoutInflater
import android.view.ViewGroup
import com.example.e_commerceshopping.R
import com.example.e_commerceshopping.base.ui.BaseFragment
import com.example.e_commerceshopping.databinding.FragmentLoginBinding
import com.example.e_commerceshopping.extension.onClick
import com.example.e_commerceshopping.ui.MainActivity
import com.google.firebase.auth.FirebaseAuth

class LoginFragment : BaseFragment<FragmentLoginBinding, MainActivity>() {

    private lateinit var auth : FirebaseAuth

    override fun onInflateView(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): FragmentLoginBinding = FragmentLoginBinding.inflate(inflater)

    override fun setupView() {
        binding.apply {
            showBottomNav(false)
            auth = FirebaseAuth.getInstance()

            btnLogin.onClick {
                showLoading(true)
                val email = edtEmail.text.toString().trim()
                val password = edtextPassword.text.toString().trim()

                if (email.isNotEmpty() and(password.isNotEmpty())){
                    auth.signInWithEmailAndPassword(email, password)
                        .addOnCompleteListener{
                            if (it.isSuccessful){
                                navigateTo(
                                    R.id.action_loginFragment_to_homeFragment,
                                    null,
                                    R.id.nav_home,
                                    false
                                )
                            }else{
                                navigateTo(
                                    R.id.action_loginFragment_to_signUpFragment,
                                    null,
                                    R.id.nav_home,
                                    false
                                )
                            }
                        }
                    edtEmail.setText("")
                    edtextPassword.setText("")
                }
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