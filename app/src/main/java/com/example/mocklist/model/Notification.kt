package com.example.mocklist.model

class Chat(
    var sender: String?,
    val receiver: String,
    val message: String,
    val isseen: String
)

class Chatlist(var id: String)