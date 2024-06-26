package com.example.cooking_companion.ui.pages

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBackIos
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardCapitalization
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.cooking_companion.data.DataSource.recommendations

/**
 * Provides a dynamic search interface with options for direct search input, recent searches, and popular searches.
 *
 * This screen features a search bar that allows users to type and submit queries. Below the search bar,
 * depending on the user input, it displays either a list of recommendations based on the typed query,
 * or lists of recent and popular searches when the search field is empty. Users can select any of the terms to perform a search.
 *
 * @param navController The navigation controller for handling navigation events, facilitating movement between UI components.
 * @param modifier Modifier for customizing the layout's appearance and padding.
 */
@Composable
fun Searching(navController: NavHostController, modifier: Modifier = Modifier) {
    var searchQuery by remember { mutableStateOf("") }
    val recentSearches = listOf("Chicken Soup", "Tomato", "Grilled Cheese")
    val popularSearches = listOf("Oreo Sundae", "Cheese", "Mince", "Chicken", "Pasta")
    val filteredRecommendations = recommendations.filter { it.startsWith(searchQuery, ignoreCase = true) }

    Column {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = modifier
                .height(100.dp)
        ) {
            IconButton(onClick = { navController.popBackStack() }, modifier = modifier.size(47.dp)) {
                Icon(
                    imageVector = Icons.Default.ArrowBackIos,
                    contentDescription = "Back arrow",
                    tint = MaterialTheme.colorScheme.primary,
                    modifier = modifier
                        .padding(start = 24.dp)
                )
            }
            OutlinedTextField(
                value = searchQuery,
                onValueChange = { searchQuery = it },
                colors = OutlinedTextFieldDefaults.colors(
                    focusedContainerColor = Color.Transparent,
                    unfocusedContainerColor = Color.Transparent,
                    disabledContainerColor = Color.Transparent,
                    focusedBorderColor = MaterialTheme.colorScheme.onBackground,
                    unfocusedBorderColor = Color.LightGray,
                ),
                keyboardOptions = KeyboardOptions(
                    capitalization = KeyboardCapitalization.Words,
                    imeAction = ImeAction.Search
                ),
                keyboardActions = KeyboardActions(
                    onSearch = {
                        navController.navigate("results/Recipes/${searchQuery}")
                    }
                ),
                shape = RoundedCornerShape(15),
                placeholder = {
                    Row (modifier = modifier.fillMaxWidth()){
                        Icon(
                            Icons.Default.Search,
                            contentDescription = "Search",
                            tint = MaterialTheme.colorScheme.outline,
                            modifier = modifier.padding(end = 9.dp)
                        )
                        Text(
                            text = "Search...",
                            color = MaterialTheme.colorScheme.outline
                        )
                    }
                },
                trailingIcon = {
                    IconButton(onClick = { searchQuery = "" }) {
                        Icon(
                            imageVector = Icons.Default.Close,
                            contentDescription = "Clear search bar",
                            tint = MaterialTheme.colorScheme.primary,
                            modifier = modifier.size(25.dp)
                        )
                    }
                },
                singleLine = true,
                modifier = Modifier
                    .padding(horizontal = 26.dp, vertical = 6.dp)
            )

        }
        if (searchQuery.isNotEmpty()) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 20.dp)
            ) {
                filteredRecommendations.forEach { recommendation ->
                    Text(
                        text = recommendation,
                        modifier = Modifier
                            .fillMaxWidth()
                            .clickable {
                                searchQuery = recommendation
                                navController.navigate("results/Recipes/${searchQuery}")
                            }
                            .padding(vertical = 8.dp),
                        style = MaterialTheme.typography.bodyLarge
                    )
                }
            }
        }else{
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
                        .clickable {
                            searchQuery = searchTerm
                            navController.navigate("results/Recipes/${searchTerm}")
                        }
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
                        .clickable {
                            searchQuery = searchTerm
                            navController.navigate("results/Recipes/${searchTerm}")
                        }
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
