package com.example.mocklist.repository.api

import androidx.lifecycle.LiveData
import com.example.mocklist.model.ApiResponseBody
import com.example.mocklist.model.EmployeeList
import com.example.mocklist.repository.api.ApiResponse
import okhttp3.MultipartBody
import okhttp3.RequestBody
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.http.*


/**
 * Complete application API End-Point
 * Note some API have JSON Response, Some don't
 */

interface RestAPIEntity {

    @GET("5d565297300000680030a986")
    fun getEmployeeList(): LiveData<ApiResponse<EmployeeList>>


}

