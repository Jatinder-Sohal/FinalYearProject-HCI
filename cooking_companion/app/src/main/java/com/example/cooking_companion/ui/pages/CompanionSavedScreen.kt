package com.example.cooking_companion.ui.pages



import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.example.cooking_companion.R
import com.example.cooking_companion.ui.components.SavedRecipeCard
import com.example.cooking_companion.ui.components.TopSearchBar

data class Recipe(
    val title: String,
    val foodImage: Int,
    val cookingTime: String,
    val difficulty: String
)
@Composable
fun CompanionSavedScreen(modifier: Modifier = Modifier) {
    val savedRecipes = listOf(
        Recipe("test", R.drawable.chickencurry_dishes, "test", "test"),
        Recipe("test", R.drawable.chickencurry_dishes, "test", "test"),
        Recipe("test", R.drawable.bbqpie_dishes, "test", "test"),
        Recipe("test", R.drawable.bbqpie_dishes, "test", "test"),
        Recipe("test", R.drawable.bbqpie_dishes, "test", "test"),
        Recipe("test", R.drawable.bbqpie_dishes, "test", "test"),
        )
    val scrollState = rememberScrollState()
    Column (
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier
            .verticalScroll(scrollState)
            .fillMaxWidth()
            .background(Color(0xFFFFFFFF))
    ) {
        TopSearchBar()
        Column {
            for(recipe in savedRecipes){
                SavedRecipeCard(recipe)
            }
        }
    }
}

