package com.bigvand.surfboard.injection

import com.bigvand.surfboard.managers.SessionManager
import com.example.mocklist.repository.HomeRepository
import com.example.mocklist.viewmodel.homepage.HomePageViewModel
import org.koin.android.ext.koin.androidApplication
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

fun appModule() = module {

    single { SessionManager(androidApplication()) }

    single { HomeRepository( get(), androidApplication()) }

    viewModel { HomePageViewModel() }


}