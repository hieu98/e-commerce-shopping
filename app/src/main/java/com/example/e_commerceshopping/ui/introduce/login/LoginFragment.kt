package com.example.e_commerceshopping.ui.introduce.login

import android.view.LayoutInflater
import android.view.ViewGroup
import com.example.e_commerceshopping.R
import com.example.e_commerceshopping.base.ui.BaseFragment
import com.example.e_commerceshopping.databinding.FragmentLoginBinding
import com.example.e_commerceshopping.extension.onClick
import com.example.e_commerceshopping.ui.MainActivity
import com.google.firebase.auth.FirebaseAuth
import org.koin.androidx.viewmodel.ext.android.viewModel

class LoginFragment : BaseFragment<FragmentLoginBinding, MainActivity>() {

    private lateinit var auth : FirebaseAuth
    private val viewModel : LoginViewModel by viewModel()

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
                                viewModel.saveUser(it.result.user?.email!!)
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
                }else {
                    showLoading(false)
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