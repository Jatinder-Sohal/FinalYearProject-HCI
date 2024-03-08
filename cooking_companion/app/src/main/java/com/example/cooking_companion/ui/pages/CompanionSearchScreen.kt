package com.example.cooking_companion.ui.pages

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.BottomSheetScaffold
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.rememberBottomSheetScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.cooking_companion.data.Category
import com.example.cooking_companion.data.DataSource
import com.example.cooking_companion.ui.components.RecipeCarousel
import com.example.cooking_companion.ui.components.SearchPageBar
import com.example.cooking_companion.ui.components.VerticalCategoryCard


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CompanionSearchScreen(navController: NavHostController, modifier: Modifier = Modifier) {
    BottomSheetScaffold(
        sheetContent = {
            Text(
                text = "Top categories",
                style = MaterialTheme.typography.headlineMedium,
                fontWeight = FontWeight.Bold,
                modifier = modifier
                    .padding(horizontal = 20.dp, vertical = 1.dp)
                    .padding(bottom = 4.dp)
                    .align(Alignment.Start)

            )
            CategoriesGrid(navController, DataSource.categoriesList)
            Spacer(modifier = Modifier.height(7.dp))
        },
        scaffoldState = rememberBottomSheetScaffoldState(),
        sheetPeekHeight = 170.dp
    ) {
        Column (
            modifier = modifier
                .fillMaxWidth()
                .background(MaterialTheme.colorScheme.background)
                .padding(top = 30.dp)
        ) {
            Text(
                text = "Search",
                style = MaterialTheme.typography.titleLarge,
                fontSize = 37.sp,
                modifier = modifier
                    .padding(horizontal = 20.dp, vertical = 4.dp)
                    .align(Alignment.Start)
            )
            SearchPageBar(navController)
            Text(
                text = "Recent recipes",
                style = MaterialTheme.typography.headlineMedium,
                fontWeight = FontWeight.Bold,
                modifier = modifier
                    .padding(horizontal = 20.dp, vertical = 1.dp)
                    .padding(top = 15.dp)
                    .align(Alignment.Start)

            )
            RecipeCarousel()
        }
    }
}

@Composable
fun CategoriesGrid(navController: NavHostController, categories: List<Category>) {
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
                VerticalCategoryCard(navController, category, Modifier.weight(1f).padding(0.dp))
            }
        }
    }
}