package com.example.cooking_companion.ui.pages

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBackIos
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Tune
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
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardCapitalization
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController

@Composable
fun Results(navController: NavHostController, query:String, modifier: Modifier = Modifier) {
    var searchQuery by remember { mutableStateOf(query) }
    var selectedTab by remember { mutableStateOf("Recipes") }
    Column(modifier.fillMaxHeight()) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = modifier
                .padding(top = 17.dp)
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
                        navController.navigate("results/${searchQuery}")
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
                modifier = modifier
                    .padding(vertical = 6.dp)
                    .padding(start = 26.dp, end = 32.dp)
                    .width(220.dp)
            )
            IconButton(onClick = {  }) {
                Icon(
                    imageVector = Icons.Default.Tune,
                    contentDescription = "Filter Search Results",
                    tint = MaterialTheme.colorScheme.primary,
                    modifier = modifier.size(30.dp)
                )
            }
        }
        Row(
            modifier = modifier
                .fillMaxWidth()
                .height(70.dp)
                .padding(horizontal = 20.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceEvenly
        ){
            ResultsTab(
                "Recipes",
                isSelected = selectedTab == "Recipes",
                onSelected = { selectedTab = "Recipes" }
            )
            ResultsTab(
                "Collections",
                isSelected = selectedTab == "Collections",
                onSelected = { selectedTab = "Collections" }
            )
            ResultsTab(
                "Ingredient",
                isSelected = selectedTab == "Ingredient",
                onSelected = { selectedTab = "Ingredient" }
            )
        }
    }
}
@Composable
fun ResultsTab(
    text : String,
    isSelected: Boolean,
    onSelected: () -> Unit,
    modifier: Modifier = Modifier
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier
            .clickable(onClick = { onSelected() })
    ) {
        Text(
            text = text,
            color = if (isSelected) MaterialTheme.colorScheme.onBackground else Color.Gray
        )
        if (isSelected) {
            Spacer(modifier = Modifier.height(4.dp))
            Box(
                modifier = Modifier
                    .height(3.dp)
                    .width(60.dp)
                    .background(Color(0xFFDE6B46))
            )
        }
    }
}