package com.example.cooking_companion.ui.pages



import androidx.compose.material3.Button
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController


@Composable
fun CompanionSavedScreen(navController: NavHostController, modifier: Modifier = Modifier) {
    Button(onClick = { navController.navigate("savedCollection")  }) {

    }
}

