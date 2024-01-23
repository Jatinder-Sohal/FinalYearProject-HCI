package com.example.cooking_companion.ui.pages


import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.example.cooking_companion.ui.components.SearchBar
import com.example.cooking_companion.ui.components.Title

@Composable
fun CompanionHomeScreen(
    modifier: Modifier = Modifier,
) {
    Column (
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier
            .fillMaxWidth()

    ){
        SearchBar()
        Title()
    }
}


