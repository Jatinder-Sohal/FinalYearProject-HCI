package com.example.cooking_companion.ui.components

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.cooking_companion.R

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun RecipeCarousel(modifier : Modifier = Modifier) {
    val images = listOf(
        R.drawable.test1,
        R.drawable.test,
        R.drawable.asian_cat
    )
    val pagerState = rememberPagerState(pageCount = {images.size})

    HorizontalPager(
        state = pagerState,
        modifier = modifier
            .fillMaxWidth()
            .height(200.dp)


    ) { page ->
        Image(
            painter = painterResource(id = images[page]),
            contentDescription = "Image $page",
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .fillMaxWidth()
                .height(200.dp)
        )
    }
}