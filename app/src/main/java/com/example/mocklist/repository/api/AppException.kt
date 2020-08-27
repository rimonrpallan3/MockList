package com.example.mocklist.repository.api

import com.example.mocklist.model.ResponseErrorBody


/**
 * API Exception class
 */
class AppException(t: Throwable?, private val responseErrorData: ResponseErrorBody?) : Exception(t){
    fun getErrorReponse() = responseErrorData
}
