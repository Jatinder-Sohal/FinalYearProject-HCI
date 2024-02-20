package com.example.cooking_companion.ui.pages

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController

@Composable
fun Results(navController: NavHostController, searchQuery:String, modifier: Modifier = Modifier) {
    Text(text = searchQuery)
}