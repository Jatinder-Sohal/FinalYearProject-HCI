package com.example.cooking_companion.ui.pages


import android.util.Log
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun CompanionHomeScreen(
    modifier: Modifier = Modifier,
) {
    Column (
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier
            .fillMaxWidth()

    ){
        SearchBar()
        Title()
    }
}


@Composable
fun SearchBar(modifier: Modifier = Modifier){
    Surface(
        modifier = modifier
            .height(60.dp)
            .width(280.dp)
            .padding(vertical = 8.dp),

        border = BorderStroke(2.dp, Color.Black),
        shape = RoundedCornerShape(50),
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp)

        ) {
            Icon(
                imageVector = Icons.Default.Search,
                contentDescription = "Search Icon",
                modifier = Modifier.size(24.dp)
            )
            Spacer(modifier = Modifier.width(40.dp))
            Text(
                text = "Search for recipes",
                fontWeight = FontWeight.Medium,
                fontSize = 15.sp
            )
        }
    }
}
@Composable
fun Title(modifier: Modifier = Modifier) {
    val configuration = LocalConfiguration.current
    val screenWidth = configuration.screenWidthDp.dp
    val screenHeight = configuration.screenHeightDp.dp

    val averageSize = (screenWidth + screenHeight) / 2
    val fontSize = (averageSize.value / 10).sp
    val boxSize = (averageSize/4)+15.dp


    Box(
        modifier = modifier
            .fillMaxWidth()
            .height(boxSize)
            .background(Color(0xFFC4F0F3))
    ) {
        Text(
            text = "Cooking",
            color = Color.Black,
            style = MaterialTheme.typography.titleLarge,
            fontSize = fontSize,
            modifier = Modifier
                .align(Alignment.TopStart)
                .padding(start = 25.dp, top=5.dp )
        )
        Text(
            text = "Companion",
            color = Color.Black,
            style = MaterialTheme.typography.titleLarge,
            fontSize = fontSize,
            modifier = Modifier
                .align(Alignment.BottomEnd)
                .padding(end = 25.dp, bottom = 10.dp)

        )
    }
}


