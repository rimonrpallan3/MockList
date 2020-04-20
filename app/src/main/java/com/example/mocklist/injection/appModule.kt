package com.example.mocklist.injection

import com.example.mocklist.managers.SessionManager
import com.example.mocklist.repository.HomeRepository
import com.example.mocklist.repository.OtpRepository
import com.example.mocklist.viewmodel.homepage.HomePageViewModel
import com.example.mocklist.viewmodel.otpPage.OtpPageViewModel
import org.koin.android.ext.koin.androidApplication
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

fun appModule() = module {

    single { SessionManager(androidApplication()) }

    single { HomeRepository( get()) }

    viewModel { HomePageViewModel(get()) }

    viewModel { OtpPageViewModel(get()) }


}