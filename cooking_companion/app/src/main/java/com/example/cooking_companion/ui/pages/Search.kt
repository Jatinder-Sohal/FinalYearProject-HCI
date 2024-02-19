package com.example.cooking_companion.ui.pages

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBackIos
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Search(navController: NavHostController, modifier: Modifier = Modifier) {
    var searchQuery by remember { mutableStateOf("") }
    val recentSearches = listOf("Test1", "Test2", "Sest3")
    val popularSearches = listOf("Test1", "Test2", "Test3", "Test4", "test5")
    Scaffold(
        topBar = {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = modifier
                    .height(100.dp)
            ) {
                Icon(
                    imageVector = Icons.Default.ArrowBackIos,
                    contentDescription = "Back arrow",
                    tint = MaterialTheme.colorScheme.primary,
                    modifier = modifier
                        .height(95.dp)
                        .padding(start = 22.dp)
                )
                OutlinedTextField(
                    value = searchQuery,
                    onValueChange = { searchQuery = it },
                    colors = TextFieldDefaults.outlinedTextFieldColors(
                        unfocusedBorderColor = Color.LightGray,
                        focusedBorderColor = MaterialTheme.colorScheme.onBackground,
                        containerColor = Color.Transparent
                    ),
                    shape = RoundedCornerShape(15),
                    leadingIcon = {
                        Icon(
                            Icons.Default.Search,
                            contentDescription = "Search",
                            tint = MaterialTheme.colorScheme.outline
                        )
                    },
                    placeholder = {
                        Text(
                            text = "Search...",
                            color = MaterialTheme.colorScheme.outline
                        )
                    },
                    modifier = Modifier
                        .padding(horizontal = 26.dp, vertical = 6.dp)
                )
            }

        },
    ) { innerPadding ->
        Column(
            modifier = modifier
                .padding(innerPadding)
        ) {
            Text(
                text = "Recent Searches",
                fontSize = 24.sp,
                color = MaterialTheme.colorScheme.primary,
                style = MaterialTheme.typography.titleSmall,
                modifier = modifier
                    .padding(horizontal = 20.dp, vertical = 4.dp)
            )
            recentSearches.forEach { searchTerm ->
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier
                        .fillMaxWidth()
                        .clickable {  }
                        .padding(horizontal = 24.dp, vertical = 10.dp)
                ) {
                    Text(
                        text = searchTerm,
                        color = MaterialTheme.colorScheme.onSurface,
                        style = MaterialTheme.typography.labelMedium,
                        fontSize = 20.sp,
                    )
                }
            }
            Text(
                text = "Popular Searches",
                fontSize = 24.sp,
                color = MaterialTheme.colorScheme.primary,
                style = MaterialTheme.typography.titleSmall,
                modifier = modifier
                    .padding(horizontal = 20.dp, vertical = 4.dp).padding(top = 8.dp)
            )
            popularSearches.forEach { searchTerm ->
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier
                        .fillMaxWidth()
                        .clickable {  }
                        .padding(horizontal = 24.dp, vertical = 10.dp)
                ) {
                    Text(
                        text = searchTerm,
                        color = MaterialTheme.colorScheme.onSurface,
                        style = MaterialTheme.typography.labelMedium,
                        fontSize = 20.sp,
                    )
                }
            }
        }
    }
}
