package com.example.e_commerceshopping.ui.introduce.login

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.e_commerceshopping.R
import com.example.e_commerceshopping.base.ui.BaseFragment
import com.example.e_commerceshopping.databinding.FragmentSignUpBinding
import com.example.e_commerceshopping.extension.onClick
import com.example.e_commerceshopping.ui.MainActivity
import com.google.android.gms.tasks.OnCompleteListener
import com.google.android.gms.tasks.Task
import com.google.firebase.auth.AuthResult
import com.google.firebase.auth.FirebaseAuth

class SignUpFragment : BaseFragment<FragmentSignUpBinding, MainActivity>(){

    private lateinit var auth : FirebaseAuth

    override fun onInflateView(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): FragmentSignUpBinding = FragmentSignUpBinding.inflate(inflater)

    override fun setupView() {
        auth = FirebaseAuth.getInstance()

        binding.apply {
            showBottomNav(false)

            header.ivNavigateBefore.onClick { popBackStack() }
            header.btnDelete.visibility = View.GONE

            btnSignup.onClick {
                showLoading(true)
                val email = edtEmail.text?.trim().toString()
                val password = edtextPassword.text?.trim().toString()

                auth.createUserWithEmailAndPassword(email, password)
                    .addOnCompleteListener {
                        if (it.isSuccessful) {
                            popBackStack()
                        } else {
                            showLoading(false)
                        }
                    }
            }
        }
    }

    override fun setupData() {
    }
}