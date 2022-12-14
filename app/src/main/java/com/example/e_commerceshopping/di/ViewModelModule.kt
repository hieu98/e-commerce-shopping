package com.example.e_commerceshopping.di

import com.example.e_commerceshopping.ui.cart.CartViewModel
import com.example.e_commerceshopping.ui.cart.checkout.CheckOutViewModel
import com.example.e_commerceshopping.ui.favorite.FavoriteViewModel
import com.example.e_commerceshopping.ui.home.HomeViewModel
import com.example.e_commerceshopping.ui.home.productdetail.ProductDetailViewModel
import com.example.e_commerceshopping.ui.introduce.login.LoginViewModel
import com.example.e_commerceshopping.ui.introduce.splash.SplashViewModel
import com.example.e_commerceshopping.ui.user.UserViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {
    viewModel { SplashViewModel(get(), get()) }
    viewModel { CartViewModel(get()) }
    viewModel { FavoriteViewModel(get()) }
    viewModel { HomeViewModel(get(), get()) }
    viewModel { LoginViewModel(get(), get()) }
    viewModel { UserViewModel(get()) }
    viewModel { CheckOutViewModel(get()) }
    viewModel { ProductDetailViewModel(get()) }
}