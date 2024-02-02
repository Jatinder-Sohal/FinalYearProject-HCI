package com.example.cooking_companion.ui.pages

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.cooking_companion.data.Category
import com.example.cooking_companion.data.DataSource.categoriesList
import com.example.cooking_companion.data.DataSource.recipesList
import com.example.cooking_companion.data.Recipe
import com.example.cooking_companion.ui.components.HorizontalCategoryItem
import com.example.cooking_companion.ui.components.RecipeCard
import com.example.cooking_companion.ui.components.Title
import com.example.cooking_companion.ui.components.TopSearchBar

@Composable
fun CompanionHomeScreen(
    modifier: Modifier = Modifier,
) {
    val scrollState = rememberScrollState()
    Column (
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier
            .verticalScroll(scrollState)
            .fillMaxWidth()

    ){
        TopSearchBar()
        Title()
        Text(
            text = "Popular Categories",
            style = MaterialTheme.typography.headlineMedium,
            fontWeight = FontWeight.Bold,
            modifier = modifier
                .padding(horizontal = 16.dp, vertical = 4.dp)
                .padding(top=8.dp)
                .align(Alignment.Start)

        )
        CategoryList(categoriesList)
        Text(
            text = "Dishes for you",
            style = MaterialTheme.typography.headlineMedium,
            fontWeight = FontWeight.Bold,
            modifier = modifier
                .padding(horizontal = 16.dp, vertical = 4.dp)
                .padding(top=8.dp)
                .align(Alignment.Start)

        )
        RecipesGrid(recipesList)
    }
}

@Composable
fun CategoryList(categories: List<Category>) {
    val subsetOfRecipes = categories.slice(0..4)
    LazyRow(
        contentPadding = PaddingValues(horizontal = 8.dp),
    ) {
        items(subsetOfRecipes) { category ->
            HorizontalCategoryItem(category)
        }
    }
}

@Composable
fun RecipesGrid(recipes: List<Recipe>) {
    val chunkedRecipes = recipes.chunked(2)
    for (chunk in chunkedRecipes) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            for (recipe in chunk) {
                RecipeCard(recipe, Modifier.weight(1f).padding(0.dp))
            }
        }
    }
}