package com.example.cooking_companion.data

import androidx.compose.ui.graphics.painter.Painter

data class Recipe(
    val name: String,
    val image: Int,
    val bookmarked: Boolean,
    val likes: Int,
    val author: String
)