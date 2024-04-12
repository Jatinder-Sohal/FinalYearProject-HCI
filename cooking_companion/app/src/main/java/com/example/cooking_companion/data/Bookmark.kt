package com.example.cooking_companion.data

data class Bookmark(
    val id: Int,
    val title: String,
    val foodImage: Int,
    val cookingTime: String,
    val difficulty: String,
    var isBookmarked: Boolean = true
)
