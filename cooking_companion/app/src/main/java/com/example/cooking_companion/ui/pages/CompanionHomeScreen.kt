package com.example.cooking_companion.ui.pages

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
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
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.cooking_companion.data.Category
import com.example.cooking_companion.data.DataSource.categoriesList
import com.example.cooking_companion.data.DataSource.recipesList
import com.example.cooking_companion.data.Recipe
import com.example.cooking_companion.ui.components.HorizontalCategoryItem
import com.example.cooking_companion.ui.components.RecipeCard
import com.example.cooking_companion.ui.components.TopSearchBar

@Composable
fun CompanionHomeScreen(
    modifier: Modifier = Modifier,
) {
    val scrollState = rememberScrollState()

    val configuration = LocalConfiguration.current
    val screenWidth = configuration.screenWidthDp.dp
    val screenHeight = configuration.screenHeightDp.dp

    val averageSize = (screenWidth + screenHeight) / 2
    val fontSize = (averageSize.value / 10).sp
    val boxSize = (averageSize/4)+15.dp
    Column (
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier
            .verticalScroll(scrollState)
            .fillMaxWidth()

    ){
        TopSearchBar()
        Box(
            modifier = modifier
                .fillMaxWidth()
                .height(boxSize)
                //#C4F0F3
                .background(Color(0xFFC4F0F3))
        ) {
            Text(
                text = "Cooking",
                color = Color.Black,
                style = MaterialTheme.typography.titleLarge,
                fontSize = fontSize,
                modifier = Modifier
                    .align(Alignment.TopStart)
                    .padding(start = 25.dp, top=5.dp )
            )
            Text(
                text = "Companion",
                color = Color.Black,
                style = MaterialTheme.typography.titleLarge,
                fontSize = fontSize,
                modifier = Modifier
                    .align(Alignment.BottomEnd)
                    .padding(end = 25.dp, bottom = 10.dp)
            )
        }
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