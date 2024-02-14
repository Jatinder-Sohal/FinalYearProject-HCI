package com.example.cooking_companion.ui.pages

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.cooking_companion.data.Category
import com.example.cooking_companion.data.DataSource
import com.example.cooking_companion.ui.components.RecipeCarousel
import com.example.cooking_companion.ui.components.SearchSearchBar
import com.example.cooking_companion.ui.components.VerticalCategoryCard


@Composable
fun CompanionSearchScreen(modifier: Modifier = Modifier) {
    val scrollState = rememberScrollState()
    Column (
        modifier = modifier
            .verticalScroll(scrollState)
            .fillMaxWidth()
            .background(Color(0xFFF0EAE2))
    ) {
        Surface(
            modifier = Modifier
                .padding(horizontal = 2.dp, vertical = 4.dp)
                .padding(top = 22.dp)
                .fillMaxWidth(),
            shape = RoundedCornerShape(25.dp),
            color = Color.White
        ) {
            Column(
                modifier = Modifier
                    .padding(0.dp)
                    .padding(bottom = 8.dp)
            ) {
                Text(
                    text = "Search",
                    style = MaterialTheme.typography.titleLarge,
                    fontSize = 46.sp,
                    modifier = modifier
                        .padding(horizontal = 20.dp, vertical = 4.dp)
                        .align(Alignment.Start)

                )
                SearchSearchBar()
            }
        }
        Surface(
            modifier = Modifier
                .padding(horizontal = 2.dp, vertical = 4.dp)
                .padding(top = 14.dp)
                .fillMaxWidth(),
            shape = RoundedCornerShape(25.dp),
            color = Color.White
        ) {
            Column(
                modifier = Modifier
                    .padding(bottom = 8.dp)
            ){
                Text(
                    text = "Recent recipes",
                    style = MaterialTheme.typography.headlineMedium,
                    fontWeight = FontWeight.Bold,
                    modifier = modifier
                        .padding(horizontal = 16.dp, vertical = 1.dp)
                        .padding(top = 8.dp)
                        .align(Alignment.Start)

                )
                RecipeCarousel()
            }
        }

        Text(
            text = "Top categories",
            style = MaterialTheme.typography.headlineMedium,
            fontWeight = FontWeight.Bold,
            modifier = modifier
                .padding(horizontal = 16.dp, vertical = 1.dp)
                .padding(top = 8.dp)
                .align(Alignment.Start)

        )
        CategoriesGrid(DataSource.categoriesList)

    }
}
@Composable
fun CategoriesGrid(categories: List<Category>) {
    val subsetOfRecipes = categories.slice(3..8)

    val chunkedRecipes = subsetOfRecipes.chunked(3)
    for (chunk in chunkedRecipes) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 6.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            for (category in chunk) {
                VerticalCategoryCard(category, Modifier.weight(1f).padding(0.dp))
            }
        }
    }
}