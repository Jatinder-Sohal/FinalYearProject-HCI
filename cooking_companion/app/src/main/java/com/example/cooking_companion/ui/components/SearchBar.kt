package com.example.cooking_companion.ui.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun TopSearchBar(modifier: Modifier = Modifier){
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
fun SearchSearchBar(modifier: Modifier = Modifier){
    Surface(
        modifier = modifier
            .height(70.dp)
            .fillMaxWidth()
            .padding(horizontal = 16.dp,vertical = 6.dp),

        border = BorderStroke(2.dp, Color.LightGray),
        shape = RoundedCornerShape(10),
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
                tint = Color.LightGray,
                modifier = Modifier.size(24.dp)
            )
            Spacer(modifier = Modifier.width(6.dp))
            Text(
                text = "Type in ingredients or dishes...",
                fontWeight = FontWeight.Medium,
                fontSize = 18.sp,
                color = Color.LightGray
            )
        }
    }
}