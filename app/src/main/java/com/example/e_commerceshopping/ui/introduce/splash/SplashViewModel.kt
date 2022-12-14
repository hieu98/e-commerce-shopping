package com.example.e_commerceshopping.ui.introduce.splash

import android.app.Application
import androidx.lifecycle.MutableLiveData
import com.example.e_commerceshopping.base.ui.BaseViewModel
import com.example.e_commerceshopping.utils.SharePreference
import kotlinx.coroutines.delay

class SplashViewModel(
    override val app: Application,
    private val sharePreference: SharePreference
) : BaseViewModel(app) {

    var user : String? = null
    var isLogin= MutableLiveData<Boolean>()

    init {
        getUser()
    }

    private fun getUser() {
        jobCall = launchJob {
            delay(2000)
            user = sharePreference.get<String>(SharePreference.KEY_USER)
            isLogin.postValue(!user.isNullOrEmpty())
        }
    }

}