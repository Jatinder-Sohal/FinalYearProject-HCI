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
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
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
            .background(MaterialTheme.colorScheme.secondaryContainer)
            .padding(horizontal = 2.dp)
    ) {
        TopSearchBar()
        Surface(
            shape = MaterialTheme.shapes.medium,
            color = MaterialTheme.colorScheme.background,
            modifier = Modifier
                .fillMaxWidth(),
        ) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
            ){
                Row(
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier
                        .fillMaxWidth(),
                ){
                    Text(
                        text = "Recipes",
                        style = MaterialTheme.typography.headlineMedium,
                        fontWeight = FontWeight.Bold,
                        modifier = modifier
                            .padding(horizontal = 32.dp, vertical = 5.dp)
                            .padding(top=8.dp)
                    )
                    Text(
                        text = "Recipes",
                        style = MaterialTheme.typography.headlineSmall,
                        fontWeight = FontWeight.Bold,
                        modifier = modifier
                            .padding(horizontal = 32.dp, vertical = 5.dp)
                            .padding(top=8.dp)
                    )
                }
                for (recipe in savedRecipes) {
                    SavedRecipeCard(recipe)
                }
            }
        }
    }
}

