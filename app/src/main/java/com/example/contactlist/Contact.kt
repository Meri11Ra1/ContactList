package com.example.contactlist

data class Contact(
    val id: Int,
    val name: String,
    val phoneNumber: String,
    val iconUrl: String,
    val isFavorite: Boolean = false // ← この行を追加
)