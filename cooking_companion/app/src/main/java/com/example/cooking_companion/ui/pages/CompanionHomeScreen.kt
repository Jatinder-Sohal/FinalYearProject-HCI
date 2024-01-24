package com.example.cooking_companion.ui.pages


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
import androidx.compose.ui.res.painterResource

import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.cooking_companion.R
import com.example.cooking_companion.data.Category
import com.example.cooking_companion.ui.components.CategoryList
import com.example.cooking_companion.ui.components.Recipe
import com.example.cooking_companion.ui.components.RecipeCard
import com.example.cooking_companion.ui.components.SearchBar
import com.example.cooking_companion.ui.components.Title

val categoriesList = listOf(
    Category("Diets", R.drawable.diet),
    Category("Courses",  R.drawable.course),
    Category("Courses",  R.drawable.dishes),
    Category("Courses",  R.drawable.dishes),
    Category("Courses",  R.drawable.dishes),
)


@Composable
fun CompanionHomeScreen(
    modifier: Modifier = Modifier,
) {
    val scrollState = rememberScrollState()
    val sampleRecipes = listOf(
        Recipe("Simple Chicken Curry", painterResource(id = R.drawable.dishessecond)),
        Recipe("Grilled Cheese", painterResource(id = R.drawable.dishessecond)),
    )
    Column (
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier
            .verticalScroll(scrollState)
            .fillMaxWidth()

    ){
        SearchBar()
        Title()
        Text(
            text = "Popular Categories",
            style = MaterialTheme.typography.headlineMedium,
            fontWeight = FontWeight.Bold,
            modifier = Modifier
                .padding(horizontal = 16.dp, vertical = 4.dp)
                .padding(top=8.dp)
                .align(Alignment.Start)

        )
        CategoryList(categoriesList)

        sampleRecipes.forEach { recipe ->
            RecipeCard(recipe)
        }
    }


}
