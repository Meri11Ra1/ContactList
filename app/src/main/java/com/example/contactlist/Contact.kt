package com.example.contactlist

data class Contact(
    val id: Int,
    val name: String,
    val phoneNumber: String,
    val iconUrl: String // アイコン画像のURLを保持
)