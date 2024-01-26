package com.example.cooking_companion.ui.pages

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.cooking_companion.ui.components.RecipeCarousel
import com.example.cooking_companion.ui.components.SearchSearchBar


@OptIn(ExperimentalFoundationApi::class)
@Composable
fun CompanionSearchScreen(modifier: Modifier = Modifier, ) {
    val scrollState = rememberScrollState()
    Column (
        modifier = modifier
            .verticalScroll(scrollState)
            .fillMaxWidth()

    ) {
        Text(
            text = "Search",
            style = MaterialTheme.typography.titleLarge,
            fontSize = 46.sp,
            modifier = modifier
                .padding(horizontal = 20.dp, vertical = 4.dp)
                .padding(top = 8.dp)
                .align(Alignment.Start)

        )
        SearchSearchBar()
        Text(
            text = "Recent recipes",
            style = MaterialTheme.typography.headlineMedium,
            fontWeight = FontWeight.Bold,
            modifier = modifier
                .padding(horizontal = 16.dp, vertical = 5.dp)
                .padding(top = 8.dp)
                .align(Alignment.Start)

        )
        RecipeCarousel()
    }
}
