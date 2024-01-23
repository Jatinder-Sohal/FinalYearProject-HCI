package com.example.cooking_companion.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


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

