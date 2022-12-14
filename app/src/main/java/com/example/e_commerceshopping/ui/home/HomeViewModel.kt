package com.example.e_commerceshopping.ui.home

import android.app.Application
import com.example.e_commerceshopping.base.ui.BaseViewModel
import com.example.e_commerceshopping.utils.SharePreference

class HomeViewModel(
    override val app: Application,
    private val sharePreference: SharePreference
) : BaseViewModel(app){

    fun logOut() {
        sharePreference.sharedPreferences.edit().clear().apply()
    }
}