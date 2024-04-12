package com.example.cooking_companion.ui.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
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
import androidx.navigation.NavHostController
import com.example.cooking_companion.data.Bookmark
import com.example.cooking_companion.data.Collection

/**
 * Displays a collection card that can be tapped to navigate to a list of recipes inside collection.
 *
 * @param collection The collection data to display.
 * @param navController The navigation controller for handling navigation events.
 * @param modifier Modifier for customizing the layout's appearance and padding.
 */
@Composable
fun CollectionOption(collection : Collection, navController: NavHostController, modifier : Modifier = Modifier){
    Card(
        modifier = modifier
            .padding(4.dp)
            .padding(bottom = 8.dp)
            .height(245.dp)
            .width(170.dp)
            .clickable { navController.navigate("savedCollection/${collection.posts}") },
        shape = RoundedCornerShape(16.dp),
        //elevation = CardDefaults.cardElevation(defaultElevation = 2.dp),
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.background,
        )
    ){
        Column{
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
            ){
                if (collection.posts != 0){
                    Image(
                        painter = painterResource(collection.images[0]),
                        contentDescription = collection.images[0].toString(),
                        contentScale = ContentScale.Crop,
                        modifier = Modifier
                            .fillMaxSize()
                    )
                }

            }
            Row{
                Card(
                    modifier = modifier
                        .width(82.dp)
                        .height(90.dp),
                    shape = RoundedCornerShape(
                        topStart = 0.dp,
                        topEnd = 0.dp,
                        bottomEnd = 0.dp,
                        bottomStart = 16.dp)
                ) {
                    if (collection.posts >= 2){
                        Image(
                            painter = painterResource(collection.images[1]),
                            contentDescription = collection.images[0].toString(),
                            contentScale = ContentScale.Crop,
                            modifier = Modifier
                                .fillMaxSize()

                        )
                    }
                }
                Card(
                    modifier = modifier
                        .padding(start = 4.dp)
                        .width(85.dp)
                        .height(90.dp),
                    shape = RoundedCornerShape(
                        topStart = 0.dp,
                        topEnd = 0.dp,
                        bottomEnd = 16.dp,
                        bottomStart = 0.dp)
                ){
                    if (collection.posts > 2){
                        Image(
                            painter = painterResource(collection.images[2]),
                            contentDescription = collection.images[2].toString(),
                            contentScale = ContentScale.Crop,
                            modifier = Modifier
                                .fillMaxSize()

                        )
                    }
                }
            }
            Text(
                text = collection.name,
                style = MaterialTheme.typography.displayMedium,
                fontWeight = FontWeight.Bold,
                fontSize = 19.sp,
                modifier = Modifier
                    .align(Alignment.CenterHorizontally)
                    .fillMaxWidth()
                    .padding(top = 1.dp, start = 8.dp)

            )
            Text(
                text = collection.posts.toString()+" Recipes",
                style = MaterialTheme.typography.displayMedium,
                fontSize = 19.sp,
                modifier = Modifier
                    .align(Alignment.CenterHorizontally)
                    .fillMaxWidth()
                    .padding(start = 8.dp)
            )
        }
    }
}
/**
 * Displays an interactive card for adding a new collection.
 *
 * This card includes an icon button that, when clicked, will invoke the provided onClick function.
 * Used to open a dialog or another interface to add a new collection.
 *
 * @param onClick The function to be called when the user decides to add a new collection.
 * @param modifier Modifier for customizing the layout's appearance and padding.
 */
@Composable
fun AddNewCollection(onClick: () -> Unit, modifier: Modifier = Modifier){
    Card(
        modifier = modifier
            .padding(4.dp)
            .padding(bottom = 8.dp)
            .height(245.dp)
            .width(170.dp)
            .clickable {onClick() },
        shape = RoundedCornerShape(16.dp),
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.background,
        ),
        border = BorderStroke(1.dp, MaterialTheme.colorScheme.onBackground),
    ){
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            IconButton(onClick = { onClick() }) {
                Icon(
                    imageVector = Icons.Default.Add,
                    contentDescription = "Add New Collection",
                    tint = Color(0xFFDE6B46),
                    modifier = Modifier.size(64.dp)
                )
            }
            Text(
                text = "Add New Collection",
                style = MaterialTheme.typography.bodyLarge,
                color = Color(0xFFDE6B46)
            )
        }
    }
}
/**
 * Bookmarked item in collection that contains relevant information and can be removed.
 *
 * This card includes a bookmark icon that, when clicked, will remove the recipe from the collection.
 * It also displays details about the bookmarked item such as title, cooking time, and difficulty.
 *
 * @param bookmark The bookmark data to display.
 * @param onBookmarkClick The function to be called when the bookmark icon is clicked.
 * @param modifier Modifier for customizing the layout's appearance and padding.
 */
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
