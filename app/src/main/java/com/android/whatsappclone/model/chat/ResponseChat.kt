package com.android.whatsappclone.model.chat

data class ResponseListChat(
    val _id:String,
    val participatn: List<String>,
    val lastMessage:String,
    val messages:String,
    val profile: ProfileData
)

data class ProfileData(
    val _id:String,
    val name:String,
    val email:String,
    val picture:String,
    val username:String,
)