package com.example.cooking_companion.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.cooking_companion.R
import com.example.cooking_companion.data.Category



@Composable
fun CategoryItem(category: Category, modifier: Modifier = Modifier) {
    Card(
        modifier = Modifier
            .padding(8.dp)
            .size(width = 120.dp, height = 100.dp),
        shape = RoundedCornerShape(10.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 10.dp)
    ) {
        Row(

        ) {
            Text(text = category.name)
            Image(
                painter = painterResource(id = category.image),
                contentDescription = category.name,
                modifier = Modifier.size(60.dp)
            )
        }
    }
}

@Composable
fun CategoryList(categories: List<Category>) {
    LazyRow(
        contentPadding = PaddingValues(horizontal = 16.dp, vertical = 8.dp),
        horizontalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        items(categories) { category ->
            CategoryItem(category)
        }
    }
}