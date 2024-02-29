package com.example.cooking_companion.ui.pages

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Bookmark
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Share
import androidx.compose.material.icons.outlined.Bookmark
import androidx.compose.material.icons.outlined.Favorite
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.cooking_companion.data.Recipe

@Composable
fun Recipe(recipe: Recipe, navController: NavHostController, modifier: Modifier = Modifier) {
    val configuration = LocalConfiguration.current
    val screenWidth = configuration.screenWidthDp.dp
    val screenHeight = configuration.screenHeightDp.dp
    val scrollState = rememberScrollState()

    Column (
        modifier = modifier
            .fillMaxSize()
            .padding()
            .verticalScroll(scrollState)
    ){
        Image(
            painter = painterResource(id =  recipe.image),
            contentDescription = recipe.name,
            contentScale = ContentScale.Crop,
            modifier = modifier
                .fillMaxWidth()
                .height(screenHeight / 2 + 50.dp)
        )
        Text(
            text = recipe.name,
            style = MaterialTheme.typography.headlineMedium,
            fontWeight = FontWeight.Medium,
            fontSize = 30.sp,
            modifier = modifier
                .padding(top = 28.dp)
                .align(Alignment.CenterHorizontally)
        )
        Text(
            text = "A simple recipe that allows easy addition of any personal swaps or addition portion sizes",
            textAlign = TextAlign.Center,
            fontSize = 18.sp,
            modifier = modifier
                .padding(top = 6.dp, bottom = 6.dp)
                .padding(horizontal = 16.dp)
                .wrapContentSize()
                .align(Alignment.CenterHorizontally)

        )
        Row(
            horizontalArrangement = Arrangement.SpaceEvenly,
            modifier = modifier
                .fillMaxWidth()
                .padding(top = 16.dp)
        ){
            IconButton(
                onClick = { /*TODO*/ },
                modifier.width(screenWidth/4)
            ) {
                Row (
                    verticalAlignment = Alignment.CenterVertically
                ){
                    Icon(
                        imageVector = if (recipe.bookmarked) Icons.Filled.Favorite else Icons.Outlined.Favorite,
                        contentDescription = "Like Button",
                        modifier.size(30.dp)
                    )
                    Text(
                        text = recipe.likes.toString(),
                        fontSize = 18.sp,
                        modifier= modifier.padding(start=2.dp)
                    )
                }
            }
            IconButton(
                onClick = { /*TODO*/ },
                modifier.width(screenWidth/4)
            ) {
                Row (
                    verticalAlignment = Alignment.CenterVertically
                ){
                    Icon(
                        imageVector = if(recipe.bookmarked) Icons.Filled.Bookmark else Icons.Outlined.Bookmark,
                        contentDescription = "Bookmarked button",
                        modifier.size(30.dp)
                    )
                    Text(
                        text = "Save",
                        fontSize = 18.sp,
                        modifier= modifier.padding(start=2.dp)
                    )
                }
            }
            IconButton(
                onClick = { /*TODO*/ },
                modifier.width(screenWidth/4)
            ) {
                Row (
                    verticalAlignment = Alignment.CenterVertically
                ){
                    Icon(
                        imageVector = Icons.Default.Share,
                        contentDescription = "Share button",
                        modifier.size(30.dp)
                    )
                    Text(
                        text = "Share",
                        fontSize = 18.sp,
                        modifier= modifier.padding(start=2.dp)
                    )

                }
            }
        }

        Divider(modifier.padding(top = 16.dp))
        Row (
            verticalAlignment = Alignment.CenterVertically,
            modifier = modifier
                .padding(8.dp)
                .padding(start = 8.dp)
        ){
            Text(
                text = "Difficulty: ",
                fontWeight = FontWeight.Bold,
                fontSize = 20.sp,
                modifier = modifier.padding(top = 16.dp)
            )
            Text(
                text = "Easy",
                fontSize = 20.sp,
                modifier = modifier.padding(top = 16.dp)
            )
        }
        Divider(modifier.padding(top = 16.dp))
        Row (
            verticalAlignment = Alignment.CenterVertically,
            modifier = modifier
                .padding(8.dp)
                .padding(start = 8.dp)
        ){
            Text(
                text = "Time ",
                fontWeight = FontWeight.Bold,
                fontSize = 20.sp,
                modifier = modifier.padding(top = 16.dp)
            )
        }
        Divider(modifier.padding(top = 16.dp))
        Row (
            verticalAlignment = Alignment.CenterVertically,
            modifier = modifier
                .padding(8.dp)
                .padding(start = 8.dp)
        ){
            Text(
                text = "Ingredients: ",
                fontWeight = FontWeight.Bold,
                fontSize = 20.sp,
                modifier = modifier.padding(top = 16.dp)
            )
        }

    }
    IconButton(
        onClick = { navController.popBackStack() },
        modifier = modifier.padding(4.dp)
    ) {
        Icon(
            imageVector = Icons.Filled.ArrowBack,
            contentDescription = "Back to last page",
            tint = Color.White,

        )
    }
}
