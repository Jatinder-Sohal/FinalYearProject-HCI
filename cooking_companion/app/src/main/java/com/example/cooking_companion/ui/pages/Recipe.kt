package com.example.cooking_companion.ui.pages

import android.content.Intent
import android.media.MediaPlayer
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Bookmark
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Remove
import androidx.compose.material.icons.filled.Share
import androidx.compose.material.icons.filled.Stop
import androidx.compose.material.icons.filled.VolumeUp
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
import androidx.compose.ui.draw.clip
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
import com.example.cooking_companion.R
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

    val ingredients = listOf("Milk", "Eggs", "Sugar", "Bread")
    var ingredientsValues by remember { mutableStateOf(listOf(2, 5, 150, 4)) }
    val ingredientType = listOf("Cups", "Whole", "Grams", "Slices")
    var servings by remember { mutableIntStateOf(1) }
    val steps = listOf(
        "Combine the ingredients for the Cajun seasoning in a small bowl. Cut the chicken into half- to three-quarter-inch cubes. Place the cubed chicken in a bowl, pour the Cajun seasoning over top, and stir to coat the chicken in spices.",
        "Add the olive oil and butter to a large deep skillet. Heat the oil and butter over medium-high until the skillet is very hot and the butter is melted and foamy. Add the seasoned chicken to the skillet and cook for a couple minutes on each side, or just until the outside gets some colour. The chicken does not need to be cooked through at this point.",
        "Add the diced yellow onion to the skillet with more Cajun seasoning and continue to sauté for about two minutes more, or just until the onion begins to soften. Allow the moisture from the onion to dissolve any browned bits from the bottom of the skillet.",
        "Next, add the pasta, fire roasted diced tomatoes (with the juices), salt and chicken broth to the skillet. Stir just until everything is evenly combined, then place a lid on top and allow the broth to come up to a boil.",
        "Once boiling, turn the heat down to medium-low and let the pasta simmer for about 10 minutes, stirring every couple of minutes, until the pasta is tender and the liquid is thick and saucy.",
        "Add the cream cheese to the skillet in chunks, then stir until it has melted into the sauce. Top the pasta with sliced green onions and serve."
    )

    val mContext = LocalContext.current
    val mMediaPlayer = MediaPlayer.create(mContext, R.raw.recipie_audio)
    var playing by remember { mutableStateOf(false) }
    Box(
        Modifier
            .fillMaxSize()
            .verticalScroll(scrollState)) {
        Column{
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
                            tint = if (liked) Color(0xFFDE6B46) else Color.Black,
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
                            tint = if (bookmarked) Color(0xFFDE6B46) else Color.Black,
                            modifier = modifier.size(30.dp)
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
                Text(
                    text = "2 Hours",
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
                Spacer(modifier = Modifier.weight(1f))
                IconButton(
                    onClick = {
                        if (servings > 1) {
                            servings--
                            ingredientsValues = ingredientsValues.map { it / 2 }
                        }
                    }
                ) {
                    Icon(
                        imageVector = Icons.Default.Remove,
                        contentDescription = "Lower Servings",
                        modifier = modifier
                            .size(45.dp)
                            .padding(top = 16.dp)
                    )
                }
                Text(
                    text = "$servings Serving",
                    fontSize = 20.sp,
                    modifier = modifier.padding(top = 16.dp)
                )
                IconButton(
                    onClick = {
                        servings++
                        ingredientsValues = ingredientsValues.map { it * 2 }
                    }
                ) {
                    Icon(
                        imageVector =  Icons.Default.Add,
                        contentDescription = "Add Servings",
                        modifier = modifier
                            .size(45.dp)
                            .padding(top = 16.dp)
                    )
                }

            }
            for (i in 0..3) {
                Row(
                    modifier = modifier
                        .fillMaxWidth()
                        .padding(horizontal = 16.dp),
                    horizontalArrangement = Arrangement.SpaceBetween,

                    ) {
                    Text(
                        text = "${ingredientsValues[i]} ${ingredientType[i]}",
                        fontSize = 18.sp,
                        modifier = Modifier.weight(1f)
                    )
                    Text(
                        text = ingredients[i],
                        fontSize = 18.sp,
                        modifier = Modifier.weight(1f)
                    )
                }
            }
            Divider(modifier = modifier.padding(top = 16.dp))
            Text(
                text = "Steps",
                fontWeight = FontWeight.Bold,
                fontSize = 20.sp,
                modifier = modifier
                    .padding(top = 16.dp, bottom = 4.dp)
                    .padding(horizontal = 16.dp)
            )
            for (i in 1..5){
                Text(
                    text = "Step $i",
                    fontSize = 17.sp,
                    fontWeight = FontWeight.Bold,
                    color = MaterialTheme.colorScheme.outline,
                    modifier = modifier
                        .padding(vertical = 16.dp)
                        .padding(horizontal = 16.dp)
                )
                Text(text = steps[i], modifier = modifier.padding(horizontal = 16.dp))
            }
            Divider(modifier = modifier.padding(top = 16.dp))
            Row{
                Text(
                    text = "Reviews",
                    fontWeight = FontWeight.Bold,
                    fontSize = 20.sp,
                    modifier = modifier
                        .padding(top = 16.dp, bottom = 4.dp)
                        .padding(horizontal = 16.dp)
                )
                Spacer(modifier = modifier.weight(1f))
                Text(
                    text = "Read All",
                    fontWeight = FontWeight.Medium,
                    color = Color(0xFFDE6B46),
                    modifier = modifier.padding(top = 32.dp, end = 16.dp)
                )
            }
            
            Text(
                text = "200 Comments",
                fontSize = 14.sp,
                modifier = modifier
                    .padding(top = 0.dp, bottom = 4.dp)
                    .padding(horizontal = 16.dp)
            )
            Review("Jeff Smith", "This is not a great recipe")
            Review("Ana Williams","I am really not impressed by the recipe. Firstly the described time is not accurate and secondly I don't like the taste.")
            Spacer(modifier = modifier.height(50.dp))
        }
        TopAppBar(
            title = {},
            navigationIcon = {
                IconButton(onClick = { navController.popBackStack() }) {
                    Icon(Icons.Filled.ArrowBack, "Back")
                }
            },
            actions = {
                if (playing){
                    IconButton(
                        onClick = {
                            mMediaPlayer.stop()
                            playing = false
                        }
                    ) {
                        Icon(
                            imageVector = Icons.Filled.Stop,
                            contentDescription = "",
                            tint = Color.White,
                            modifier = Modifier.size(40.dp)
                        )
                    }
                }else{
                    IconButton(
                        onClick = {
                            mMediaPlayer.start()
                            playing = true
                        }
                    ) {
                        Icon(
                            imageVector = Icons.Filled.VolumeUp,
                            contentDescription = "",
                            tint = Color.White,
                            modifier = Modifier.size(40.dp)
                        )
                    }
                }

            },
            colors =
            TopAppBarDefaults.topAppBarColors(
                containerColor = Color.Transparent,
                navigationIconContentColor = Color.White,
                titleContentColor = Color.White
            )
        )
    }
}
@Composable
fun Review(name: String, comment:String, modifier: Modifier = Modifier){
    Row (
        modifier
            .fillMaxWidth()
            .padding(start = 16.dp, top = 16.dp, bottom = 8.dp)
    ){
        Box(
            modifier = modifier
                .size(47.dp)
                .clip(CircleShape)
                .background(Color(0xFFFCAC34))

        ){
            Text(
                text = name[0].toString(),
                textAlign = TextAlign.Center,
                fontWeight = FontWeight.Bold,
                fontSize = 20.sp,
                modifier = modifier
                    .fillMaxWidth()
                    .align(Alignment.Center)
            )
        }
        Column {
            Text(
                text = name,
                fontWeight = FontWeight.Bold,
                fontSize = 18.sp,
                modifier = modifier
                    .padding(start = 8.dp, top = 4.dp)

            )
            Text(
                text = comment,
                modifier = modifier
                    .padding(start = 8.dp)

            )
        }

    }
}