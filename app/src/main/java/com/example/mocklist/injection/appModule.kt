package com.example.mocklist.injection

import com.example.mocklist.managers.SessionManager
import com.example.mocklist.repository.EmployeeListRepository
import com.example.mocklist.repository.api.RestAPIEntity
import com.example.mocklist.repository.api.RestApiService
import com.example.mocklist.viewmodel.employeeListPage.EmployeeListPageViewModel
import com.example.mocklist.viewmodel.homepage.HomePageViewModel
import com.example.mocklist.viewmodel.otpPage.OtpPageViewModel
import org.koin.android.ext.koin.androidApplication
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

fun appModule() = module {

    single { SessionManager(androidApplication()) }

    single { RestApiService(get(),androidApplication()).getRetrofitInstance() }

    single { RestApiService(get(),androidApplication()).create(get(), RestAPIEntity::class.java) }

    single { EmployeeListRepository(get()) }


    viewModel { HomePageViewModel(get()) }

    viewModel { OtpPageViewModel(get()) }

    viewModel { EmployeeListPageViewModel(get()) }


}