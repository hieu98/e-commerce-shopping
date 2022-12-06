package com.example.e_commerceshopping.di

import android.content.Context
import com.example.e_commerceshopping.domain.prefs.AppSettings
import com.example.e_commerceshopping.utils.SharePreference
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module

const val PREF_NAME = "PREF_NAME"
val sharedPreferencesModule = module {
    single { androidContext().getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE) }
    single { androidContext().contentResolver }
    single { SharePreference(get(), get()) }
    single { AppSettings(androidContext()) }
}