package com.example.e_commerceshopping.ui.introduce.splash

import android.app.Application
import com.example.e_commerceshopping.base.ui.BaseViewModel
import com.example.e_commerceshopping.utils.SharePreference

class SplashViewModel(
    override val app: Application,
    val sharePreference: SharePreference
) : BaseViewModel(app) {

    var splash: Boolean? = null

    init {
        checkSplash()
    }

    fun checkSplash() : Boolean{
        splash = sharePreference.get<Boolean>(SharePreference.KEY_SPLASH)
        return splash ?: false
    }

    fun passSplash(){
        sharePreference.save(SharePreference.KEY_SPLASH, true)
    }
}