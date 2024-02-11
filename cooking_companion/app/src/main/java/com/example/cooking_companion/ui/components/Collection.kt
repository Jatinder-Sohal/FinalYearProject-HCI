package com.example.cooking_companion.ui.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Bookmark
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.cooking_companion.data.Bookmark

@Composable
fun CollectionOption(modifier : Modifier = Modifier){
    Card(
        modifier = modifier
            .padding(4.dp)
            .padding(bottom = 8.dp)
            .height(245.dp)
            .width(170.dp),
        shape = RoundedCornerShape(16.dp),
        //elevation = CardDefaults.cardElevation(defaultElevation = 2.dp),
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.background,
            contentColor = Color.Black
        )
    ){
        Column(){
            Card(
                modifier = modifier
                    .padding(bottom = 4.dp)
                    .fillMaxWidth()
                    .height(100.dp),
                shape = RoundedCornerShape(
                    topStart = 16.dp,
                    topEnd = 16.dp,
                    bottomEnd = 0.dp,
                    bottomStart = 0.dp)
            ){}
            Row(){
                Card(
                    modifier = modifier
                        .padding(end = 4.dp)
                        .width(85.dp)
                        .height(90.dp),
                    shape = RoundedCornerShape(
                        topStart = 0.dp,
                        topEnd = 0.dp,
                        bottomEnd = 0.dp,
                        bottomStart = 16.dp)){}
                Card(
                    modifier = modifier
                        //.padding(end = 4.dp)
                        .width(85.dp)
                        .height(90.dp),
                    shape = RoundedCornerShape(
                        topStart = 0.dp,
                        topEnd = 0.dp,
                        bottomEnd = 16.dp,
                        bottomStart = 0.dp)){}
            }
            Text(
                text = "test",
                style = MaterialTheme.typography.displayMedium,
                fontWeight = FontWeight.Bold,
                fontSize = 19.sp,
                modifier = Modifier
                    .align(Alignment.CenterHorizontally)
                    .fillMaxWidth()
                    .padding(top = 1.dp, start = 4.dp)

            )
            Text(
                text = "test",
                style = MaterialTheme.typography.displayMedium,
                fontWeight = FontWeight.Bold,
                fontSize = 19.sp,
                modifier = Modifier
                    .align(Alignment.CenterHorizontally)
                    .fillMaxWidth()
                    .padding(start = 4.dp)
            )
        }
    }
}
@Composable
fun CollectionItem(bookmark: Bookmark,onBookmarkClick: () -> Unit, modifier: Modifier = Modifier) {
    val darkTheme = isSystemInDarkTheme()
    Card (
        shape = RoundedCornerShape(20.dp),
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.secondaryContainer,
            contentColor = MaterialTheme.colorScheme.inverseSurface
            ),
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp),
        modifier = modifier
            .fillMaxWidth()
            .height(110.dp)
            .padding(vertical = 10.dp, horizontal = 20.dp)
    ){
        Row(
            modifier = modifier
                .padding(2.dp)
                .fillMaxWidth()
        ) {
            Image(
                painter = painterResource(id = bookmark.foodImage),
                contentDescription = bookmark.title,
                modifier = modifier
                    .padding(horizontal = 10.dp)
                    .size(85.dp)
                    .clip(RoundedCornerShape(20.dp)),
                contentScale = ContentScale.Crop
            )
            Column(
                verticalArrangement = Arrangement.SpaceEvenly,
                modifier = Modifier
                    .padding(start = 8.dp)
                    .fillMaxHeight()

            ) {
                Text(
                    text = bookmark.title,
                    style = MaterialTheme.typography.titleMedium,
                    fontSize = 20.sp,
                )
                Text(
                    text = bookmark.cookingTime,
                    style = MaterialTheme.typography.bodyMedium
                )
                Text(
                    text = bookmark.difficulty,
                    style = MaterialTheme.typography.bodyMedium,
                    color =
                    if(darkTheme){
                        when{
                            (bookmark.difficulty == "Easy") -> Color.Green
                            (bookmark.difficulty == "Moderate")-> Color.Yellow
                            else -> Color(0xFFFF0011)
                        }
                    } else {
                        when{
                            (bookmark.difficulty == "Easy") -> Color(0xFF17A01C)
                            (bookmark.difficulty == "Moderate")-> Color(0xFFD6C102)
                            else -> Color(0xFFC9000D)
                        }
                    }

                )
            }
            Spacer(Modifier.weight(1f))
            IconButton(
                onClick = onBookmarkClick,
                modifier = Modifier
                    .align(Alignment.CenterVertically)
                    .padding(end = 10.dp)
            ) {
                Icon(
                    imageVector = Icons.Filled.Bookmark,
                    contentDescription = "Bookmark",
                    modifier = Modifier
                        .align(Alignment.CenterVertically)
                        .size(40.dp),
                )
            }
        }
    }
}
