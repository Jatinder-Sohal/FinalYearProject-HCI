package com.example.cooking_companion.ui.pages


import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
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
import com.example.cooking_companion.data.Recipe
import com.example.cooking_companion.ui.components.CategoryList
import com.example.cooking_companion.ui.components.HomeSearchBar
import com.example.cooking_companion.ui.components.RecipeCard
import com.example.cooking_companion.ui.components.Title

val categoriesList = listOf(
    Category("Diets", R.drawable.diet_cat),
    Category("Courses",  R.drawable.course_cat),
    Category("Healthy",  R.drawable.healthy_cat),
    Category("Asian",  R.drawable.asian_cat),
    Category("Simple",  R.drawable.simple_cat),
)


@Composable
fun CompanionHomeScreen(
    modifier: Modifier = Modifier,
) {
    val scrollState = rememberScrollState()
    val recipesList = listOf(
        Recipe("Chicken Curry", painterResource(id = R.drawable.chickencurry_dishes)),
        Recipe("Grilled Cheese", painterResource(id = R.drawable.grilledcheese_dishes)),
        Recipe("Fried Noodles", painterResource(id = R.drawable.noodles_dishes)),
        Recipe("BBQ Pie", painterResource(id = R.drawable.bbqpie_dishes)),
        Recipe("Pumpkin Soup", painterResource(id = R.drawable.pumpkinsoup_dishes)),
        Recipe("Chicken Waffles ", painterResource(id = R.drawable.chickenwaffles_dishes)),
    )
    Column (
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier
            .verticalScroll(scrollState)
            .fillMaxWidth()

    ){
        HomeSearchBar()
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