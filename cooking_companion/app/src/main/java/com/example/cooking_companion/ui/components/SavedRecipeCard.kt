package com.example.cooking_companion.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
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
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.cooking_companion.data.Bookmark

@Composable
fun SavedRecipeCard(bookmark: Bookmark,onBookmarkClick: () -> Unit, modifier: Modifier = Modifier) {
    Card (
        shape = RoundedCornerShape(20.dp),
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.secondaryContainer,
            contentColor = MaterialTheme.colorScheme.inverseSurface
            ),
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp),
        modifier = modifier
            .height(110.dp)
            .width(350.dp)
            .padding(vertical = 10.dp, horizontal = 10.dp)
    ){
        Row(
            modifier = modifier
                .padding(4.dp)
                .fillMaxWidth()
        ) {
            Image(
                painter = painterResource(id = bookmark.foodImage),
                contentDescription = bookmark.title,
                modifier = modifier
                    .padding(horizontal = 10.dp)
                    .size(85.dp)
                    .clip(RoundedCornerShape(20.dp))
            )
            Column(
                modifier = Modifier
                    .padding(start = 8.dp)

            ) {
                Text(
                    text = bookmark.title,
                    style = MaterialTheme.typography.titleMedium,
                    fontSize = 25.sp,
                )
                Text(
                    text = bookmark.cookingTime,
                    style = MaterialTheme.typography.bodyMedium
                )
                Text(
                    text = bookmark.difficulty,
                    style = MaterialTheme.typography.bodySmall
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
