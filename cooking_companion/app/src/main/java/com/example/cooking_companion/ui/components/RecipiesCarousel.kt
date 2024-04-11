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
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBackIos
import androidx.compose.material.icons.filled.ArrowForwardIos
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.cooking_companion.R
import kotlinx.coroutines.launch

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun RecipeCarousel(modifier : Modifier = Modifier) {
    val images = listOf(
        R.drawable.fish_recent,
        R.drawable.grilledcheese_recent,
        R.drawable.pancakes_recent
    )
    val pagerState = rememberPagerState(pageCount = {images.size})
    val coroutineScope = rememberCoroutineScope()

    HorizontalPager(
        state = pagerState,
        modifier = modifier
            .fillMaxWidth()
            .height(220.dp)
    ) { page ->
        Image(
            painter = painterResource(id = images[page]),
            contentDescription = "Image $page",
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .fillMaxWidth()
                .height(220.dp)
                .padding(horizontal = 13.dp, vertical = 10.dp)
                .clip(RoundedCornerShape(percent = 10))
        )
    }
    Box(
        modifier = modifier
            .fillMaxWidth()
    ) {
        Row(
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .align(Alignment.Center)
        ) {
            IconButton(onClick= {
                coroutineScope.launch {
                    val previousPage = (pagerState.currentPage - 1).coerceAtLeast(0)
                    pagerState.animateScrollToPage(previousPage)
                }
            }){
                Icon(
                    imageVector = Icons.Filled.ArrowBackIos,
                    contentDescription = "",
                    modifier = Modifier.size(28.dp)
                )
            }
            images.forEachIndexed { index, _ ->
                CarouselIndicator(isSelected = pagerState.currentPage == index)
            }
            IconButton(onClick={
                coroutineScope.launch {
                    val nextPage = (pagerState.currentPage + 1).coerceAtMost(images.lastIndex)
                    pagerState.animateScrollToPage(nextPage)
                }
            }){
                Icon(
                    imageVector = Icons.Filled.ArrowForwardIos,
                    contentDescription = "",
                    modifier = Modifier.size(28.dp)
                )
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
                .background(MaterialTheme.colorScheme.onBackground),
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
