package com.example.e_commerceshopping.di

import com.example.e_commerceshopping.ui.cart.CartViewModel
import com.example.e_commerceshopping.ui.favorite.FavoriteViewModel
import com.example.e_commerceshopping.ui.home.HomeViewModel
import com.example.e_commerceshopping.ui.introduce.login.LoginViewModel
import com.example.e_commerceshopping.ui.introduce.splash.SplashViewModel
import com.example.e_commerceshopping.ui.user.UserViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {
    viewModel { SplashViewModel(get()) }
    viewModel { CartViewModel(get()) }
    viewModel { FavoriteViewModel(get()) }
    viewModel { HomeViewModel(get()) }
    viewModel { LoginViewModel(get()) }
    viewModel { UserViewModel(get()) }
}