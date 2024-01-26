package com.example.cooking_companion.ui.components

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.cooking_companion.R

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun RecipeCarousel(modifier : Modifier = Modifier) {
    val images = listOf(
        R.drawable.fish_recent,
        R.drawable.grilledcheese_recent,
        R.drawable.pancakes_recent
    )
    val pagerState = rememberPagerState(pageCount = {images.size})

    HorizontalPager(
        state = pagerState,
        modifier = modifier
            .fillMaxWidth()
            .height(230.dp)
    ) { page ->
        Image(
            painter = painterResource(id = images[page]),
            contentDescription = "Image $page",
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .fillMaxWidth()
                .height(220.dp)
                .padding(13.dp)
                .clip(RoundedCornerShape(percent = 10))
        )
    }
    Box(
        modifier = modifier
            .fillMaxWidth()
    ) {
        Row(
            horizontalArrangement = Arrangement.Center,
            modifier = Modifier
                .align(Alignment.Center)
        ) {
            images.forEachIndexed { index, _ ->
                CarouselIndicator(isSelected = pagerState.currentPage == index)
            }
        }
    }
}

@Composable
fun CarouselIndicator(isSelected: Boolean, modifier : Modifier = Modifier) {
    if (isSelected)
        Box(
            modifier = modifier
                .padding(horizontal = 4.dp)
                .width(45.dp)
                .height(14.dp)
                .clip(RoundedCornerShape(percent = 50))
                .background(Color.Black),
        )
    else
        Box(
            modifier = Modifier
                .padding(horizontal = 4.dp)
                .size(12.dp)
                .clip(CircleShape)
                .background(Color.Gray)
        )
}
