package com.example.cooking_companion.ui.pages

import android.content.Intent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
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
import androidx.compose.material.icons.outlined.BookmarkBorder
import androidx.compose.material.icons.outlined.FavoriteBorder
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.content.ContextCompat.startActivity
import androidx.navigation.NavHostController
import com.example.cooking_companion.data.Recipe

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Recipe(recipe: Recipe, navController: NavHostController, modifier: Modifier = Modifier) {
    var bookmarked by remember { mutableStateOf(recipe.bookmarked) }
    var liked by remember { mutableStateOf(recipe.bookmarked) }
    var likesCount by remember { mutableIntStateOf(recipe.likes) }
    val configuration = LocalConfiguration.current
    val screenWidth = configuration.screenWidthDp.dp
    val screenHeight = configuration.screenHeightDp.dp
    val scrollState = rememberScrollState()
    val imageHeight = (screenHeight/2) + 50.dp
    val context = LocalContext.current

    var ingredients by remember { mutableStateOf(listOf(" Cups Milk", " Eggs", "Grams of Sugar", "Slices of Bread")) }
    var ingredientsValues by remember { mutableStateOf(listOf(2, 5, 150, 4)) }
    Box(Modifier.fillMaxSize()) {
        Column(Modifier.verticalScroll(scrollState)) {
            Image(
                painter = painterResource(id = recipe.image),
                contentDescription = recipe.name,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(imageHeight)
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
                    onClick = {
                        if (liked) {
                            likesCount--
                        }else likesCount++
                        liked = !liked},
                    modifier.width(screenWidth/4)
                ) {
                    Row (
                        verticalAlignment = Alignment.CenterVertically
                    ){
                        Icon(
                            imageVector = if (liked) Icons.Filled.Favorite else Icons.Outlined.FavoriteBorder,
                            contentDescription = "Like Button",
                            tint = if (liked) Color.Red else Color.Black,
                            modifier = modifier.size(30.dp)
                        )
                        Text(
                            text = likesCount.toString(),
                            fontSize = 18.sp,
                            modifier= modifier.padding(start=2.dp)
                        )
                    }
                }
                IconButton(
                    onClick = { bookmarked = !bookmarked },
                    modifier.width(screenWidth/4)
                ) {
                    Row (
                        verticalAlignment = Alignment.CenterVertically
                    ){
                        Icon(
                            imageVector = if(bookmarked) Icons.Filled.Bookmark else Icons.Outlined.BookmarkBorder,
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
                    onClick = {
                        val sendIntent: Intent = Intent().apply {
                        action = Intent.ACTION_SEND
                        putExtra(Intent.EXTRA_TEXT, recipe.name)
                        type = "text/plain"
                        }
                        val shareIntent = Intent.createChooser(sendIntent, null)
                        startActivity(context, shareIntent, null)
                    },
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
                    text = "Time:  ",
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
            Column {
                ingredients.zip(ingredientsValues).forEach { (ingredient, amount) ->
                    Row {
                        Text(text = amount.toString()
                        )
                        Text(text = ingredient, modifier = Modifier.weight(1f)
                        )

                    }
                }
            }
        }
        TopAppBar(
            title = {},
            navigationIcon = {
                IconButton(onClick = { navController.popBackStack() }) {
                    Icon(Icons.Filled.ArrowBack, "Back")
                }
            },
            colors =
            if (scrollState.value.dp > imageHeight) {
                TopAppBarDefaults.topAppBarColors(
                containerColor = MaterialTheme.colorScheme.onBackground,
                navigationIconContentColor = Color.White,
                titleContentColor = Color.White
                )
            }else{TopAppBarDefaults.topAppBarColors(
                containerColor = Color.Transparent,
                navigationIconContentColor = Color.White,
                titleContentColor = Color.White
                )
            },
        )
    }
}