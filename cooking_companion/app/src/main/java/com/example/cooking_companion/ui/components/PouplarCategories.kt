package com.example.cooking_companion.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
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
import com.example.cooking_companion.data.Category


@Composable
fun HorizontalCategoryItem(category: Category, modifier: Modifier = Modifier) {
    Card(
        modifier = modifier
            .padding(8.dp)
            .size(width = 160.dp, height = 80.dp),
        shape = RoundedCornerShape(15.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 15.dp),
        colors = CardDefaults.cardColors(
            containerColor = Color.White,
            contentColor = Color.Black
        )

    ) {
        Column(
            verticalArrangement = Arrangement.Center
        ) {
            Row(
                modifier = modifier
                    .fillMaxSize(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = category.name,
                    fontSize = 18.sp,
                    modifier = Modifier
                        .padding(start = 7.dp)
                        .weight(1f)
                )
                Box(
                    modifier = Modifier
                        .size(70.dp)
                        .padding(end = 10.dp)
                ) {
                    Image(
                        painter = painterResource(id = category.image),
                        contentDescription = category.name,
                        modifier = Modifier
                            .fillMaxSize()

                    )
                }
            }
        }
    }}
@Composable
fun CategoryList(categories: List<Category>) {
    LazyRow(
        contentPadding = PaddingValues(horizontal = 8.dp),

    ) {
        items(categories) { category ->
            HorizontalCategoryItem(category)
        }
    }
}

@Composable
fun VerticalCategoryCard(category: Category, modifier : Modifier = Modifier){
    Card(
        modifier = modifier
            .padding(8.dp)
            .height(150.dp),

        colors = CardDefaults.cardColors(
            containerColor = Color(0xFFFFF6E4),
            contentColor = Color.Black),
        shape = RoundedCornerShape(20.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 2.dp)
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
            modifier = modifier
                .fillMaxSize()
        ) {
            Image(
                painter = painterResource(id =  category.image),
                contentDescription = category.name,
                modifier = Modifier
                    .width(60.dp)
                    .height(60.dp)
            )
            Text(
                text = category.name,
                style = MaterialTheme.typography.bodySmall,
                fontSize = 19.sp,
                modifier = Modifier
                    .padding(top = 5.dp)
            )
        }
    }
}

