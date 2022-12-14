package com.example.e_commerceshopping.ui.introduce.login

import android.app.Application
import com.example.e_commerceshopping.base.ui.BaseViewModel
import com.example.e_commerceshopping.utils.SharePreference

class LoginViewModel(
    override val app: Application,
    private val sharePreference: SharePreference
) : BaseViewModel(app){

    fun saveUser(email: String){
        sharePreference.save(SharePreference.KEY_USER, email)
    }
}