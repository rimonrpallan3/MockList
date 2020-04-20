package com.example.mocklist.model

class Data(
    var user: String?,
    val icon: Int,
    val body: String,
    val title: String,
    val sented: String?
)

class MyResponse(val success: Int)

class Sender(val data: Data,
             val to: String)

class Token(val token: String)