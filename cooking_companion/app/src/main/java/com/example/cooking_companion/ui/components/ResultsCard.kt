package com.example.cooking_companion.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ThumbUp
import androidx.compose.material.icons.outlined.Bookmark
import androidx.compose.material.icons.outlined.BookmarkBorder
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.Text
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.cooking_companion.data.Recipe

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun RecipeCard(recipe: Recipe, modifier : Modifier = Modifier){
    var bookmarked by remember { mutableStateOf(recipe.bookmarked) }
    val width = LocalConfiguration.current.screenWidthDp.dp/2

    val sheetState = rememberModalBottomSheetState()
    var showBottomSheet by remember { mutableStateOf(false) }

    Card(
        modifier = modifier
            .padding(horizontal = 6.dp)
            .height(240.dp)
            .width(width - 20.dp),
        colors = CardDefaults.cardColors(
            containerColor = Color.Transparent
        ),
    ) {
        Box {
            Image(
                painter = painterResource(id =  recipe.image),
                contentDescription = recipe.name,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .height(180.dp)
                    .clip(RoundedCornerShape(percent = 10))
            )
            Row {
                Icon(
                    imageVector = Icons.Filled.ThumbUp,
                    contentDescription = "Likes",
                    tint = Color.White,
                    modifier = modifier
                        .padding(horizontal = 10.dp, vertical = 8.dp)
                        .size(20.dp)
                )
                Text(
                    text = recipe.likes.toString() + "%",
                    color = Color.White,
                    modifier = modifier.padding(vertical = 6.dp)
                )
                Spacer(modifier = modifier.weight(1f))
                IconButton(onClick = { if (bookmarked){bookmarked = false} else{showBottomSheet = true} }) {
                    Icon(
                        imageVector = if (bookmarked) Icons.Outlined.Bookmark else Icons.Outlined.BookmarkBorder,
                        contentDescription = "Save recipe",
                        tint = Color.White,
                        modifier = modifier.padding(vertical = 6.dp, horizontal = 8.dp)
                    )
                }
            }

        }
        Text(
            text = recipe.name,
            style = MaterialTheme.typography.displayMedium,
            fontSize = 18.sp,
            modifier = Modifier
                //.align(Alignment.CenterHorizontally)
                .padding(top = 5.dp, start = 5.dp)
                .wrapContentSize()
        )
        Text(
            text = "By: "+ recipe.author,
            style = MaterialTheme.typography.displayMedium,
            fontSize = 15.sp,
            color = Color(0xFFDE6B46),
            modifier = Modifier
                //.align(Alignment.CenterHorizontally)
                .padding(top = 5.dp, start = 5.dp)
        )

        if (showBottomSheet) {
            ModalBottomSheet(
                onDismissRequest = { showBottomSheet = false },
                sheetState = sheetState
            ) {
                SelectCollectionSheet(
                    onCollectionSelected = {
                        bookmarked = true
                        showBottomSheet = false
                    },
                )
            }
        }
    }
}