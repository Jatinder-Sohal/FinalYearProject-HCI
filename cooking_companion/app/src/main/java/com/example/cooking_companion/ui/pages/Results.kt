package com.example.cooking_companion.ui.pages

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBackIos
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
import androidx.navigation.NavHostController

@Composable
fun Results(navController: NavHostController, query:String, modifier: Modifier = Modifier) {
    var searchQuery by remember { mutableStateOf(query) }
    Column {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = modifier
                .height(100.dp)
        ) {
            IconButton(onClick = { navController.popBackStack() }) {
                Icon(
                    imageVector = Icons.Default.ArrowBackIos,
                    contentDescription = "Back arrow",
                    tint = MaterialTheme.colorScheme.primary,
                    modifier = modifier
                        .height(95.dp)
                        .padding(start = 22.dp)
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
                modifier = Modifier
                    .padding(horizontal = 26.dp, vertical = 6.dp)
            )

        }
    }
}