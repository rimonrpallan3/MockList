package com.example.mocklist.model

data class ResponseErrorBody(
    val  statusCode : String ?,
    val  message : String ?

)

data class ResponseError(
    val  error : ResponseErrorBody?
)
