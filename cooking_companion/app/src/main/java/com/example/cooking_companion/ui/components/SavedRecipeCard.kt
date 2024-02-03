package com.example.cooking_companion.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.cooking_companion.ui.pages.Recipe

@Composable
fun SavedRecipeCard(recipe: Recipe, modifier: Modifier = Modifier) {
    Card (
        shape = RoundedCornerShape(20.dp),
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.secondaryContainer,
            contentColor = MaterialTheme.colorScheme.inverseSurface
            ),
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp),
        modifier = modifier
            .height(110.dp)
            .width(350.dp)
            .padding(vertical = 10.dp, horizontal = 10.dp)
    ){
        Row(
            modifier = modifier
                .padding(4.dp)
                .fillMaxWidth()
        ) {
            Image(
                painter = painterResource(id = recipe.foodImage),
                contentDescription = recipe.title,
                modifier = modifier
                    .padding(horizontal = 10.dp)
                    .size(85.dp)
                    .clip(RoundedCornerShape(20.dp))
            )
            Column(
                modifier = Modifier
                    .padding(start = 8.dp)

            ) {
                Text(
                    text = recipe.title,
                    style = MaterialTheme.typography.titleMedium,
                    fontSize = 25.sp,
                )
                Text(
                    text = recipe.cookingTime,
                    style = MaterialTheme.typography.bodyMedium
                )
                Text(
                    text = recipe.difficulty,
                    style = MaterialTheme.typography.bodySmall
                )
            }
        }
    }
}