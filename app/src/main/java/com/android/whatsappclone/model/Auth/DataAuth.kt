package com.android.whatsappclone.model.Auth

data class LoginBody(
    val username: String,
    val password: String
)

data class RegisterBody(
    val email:String,
    val username:String,
    val password:String
)