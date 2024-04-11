package com.example.cooking_companion.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
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
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.DefaultTintColor
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.cooking_companion.data.Category
import com.example.cooking_companion.data.DataSource.darkMode

@Composable
fun HorizontalCategoryItem(navController: NavHostController, category: Category, modifier: Modifier = Modifier) {
    Card(
        modifier = modifier
            .padding(8.dp)
            .size(width = 160.dp, height = 80.dp)
            .clickable{navController.navigate("results/Collections/${category.name}")},
        shape = RoundedCornerShape(15.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 15.dp),
        colors = CardDefaults.cardColors(
            containerColor = if (darkMode.value) Color.Black else Color.White,
            contentColor = if (darkMode.value) Color.White else Color.Black,
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
fun VerticalCategoryCard(navController: NavHostController, category: Category, modifier : Modifier = Modifier){
    Card(
        modifier = modifier
            .padding(6.dp)
            .height(148.dp)
            .clickable{navController.navigate("results/Collections/${category.name}")},
        colors = CardDefaults.cardColors(
            containerColor = Color(0xFFC4F0F3),
            contentColor = Color.Black),
        shape = RoundedCornerShape(20.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 0.1.dp)
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
            modifier = modifier
                .fillMaxSize()
                .padding(bottom = 16.dp)
        ) {
            Image(
                painter = painterResource(id =  category.image),
                contentDescription = category.name,
                modifier = Modifier
                    .width(57.dp)
                    .height(57.dp)
            )
            Text(
                text = category.name,
                style = MaterialTheme.typography.bodySmall,
                fontSize = 18.sp,
                modifier = Modifier
                    .padding(top = 5.dp)
            )
        }
    }
}

