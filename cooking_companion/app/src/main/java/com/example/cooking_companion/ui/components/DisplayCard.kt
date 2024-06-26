package com.example.cooking_companion.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.cooking_companion.data.Recipe

/**
 * Displays a card view of a recipe that users can tap to navigate to the detailed recipe page.
 *
 * This composable function creates a card view with an image on top and the recipe's name below. The card
 * can be tapped to navigate to a detailed view of the recipe specified by `recipe.name`.
 *
 * @param navController The navigation controller used for handling navigation events.
 * @param recipe The recipe data to display, which includes the name and image resource.
 * @param modifier The modifier to be applied to the card layout.
 */
@Composable
fun DisplayCard(navController: NavHostController, recipe: Recipe, modifier: Modifier = Modifier) {
    val darkTheme = isSystemInDarkTheme()
    Card(
        modifier = modifier
            .padding(8.dp)
            .height(240.dp)
            //.clickable{navController.navigate("results/Recipes/${recipe.name}")},
            .clickable{navController.navigate("Recipe/${recipe.name}/recipesList")},
        colors = CardDefaults.cardColors(
            containerColor = if (darkTheme) Color.Black else Color.White,
            contentColor = if (darkTheme) Color.White else Color.Black,
        ),
        shape = MaterialTheme.shapes.medium,
        elevation = CardDefaults.cardElevation(defaultElevation = 2.dp),
    ) {
        Box {
            Image(
                painter = painterResource(id =  recipe.image),
                contentDescription = recipe.name,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(200.dp)
            )
        }
        Text(
            text = recipe.name,
            style = MaterialTheme.typography.displayMedium,
            fontWeight = FontWeight.Bold,
            fontSize = 19.sp,
            modifier = Modifier
                .align(Alignment.CenterHorizontally)
                .padding(top = 5.dp)
        )
    }
}

