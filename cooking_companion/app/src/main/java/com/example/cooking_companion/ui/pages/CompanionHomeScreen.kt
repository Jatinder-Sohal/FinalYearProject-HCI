package com.example.cooking_companion.ui.pages


import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.cooking_companion.R
import com.example.cooking_companion.data.Category
import com.example.cooking_companion.ui.components.CategoryList
import com.example.cooking_companion.ui.components.SearchBar
import com.example.cooking_companion.ui.components.Title

val categoriesList = listOf(
    Category("Diets", R.drawable.dishes),
    Category("Courses",  R.drawable.dishes),
    Category("Courses",  R.drawable.dishes),
    Category("Courses",  R.drawable.dishes),
    Category("Courses",  R.drawable.dishes),
)

@Composable
fun CompanionHomeScreen(
    modifier: Modifier = Modifier,
) {
    Column (
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier
            .fillMaxWidth()

    ){
        SearchBar()
        Title()
        Text(
            text = "Popular Categories",
            style = MaterialTheme.typography.headlineMedium,
            fontWeight = FontWeight.Bold,
            modifier = Modifier
                .padding(16.dp)
                .align(Alignment.Start)

        )
        CategoryList(categoriesList)
    }

}
