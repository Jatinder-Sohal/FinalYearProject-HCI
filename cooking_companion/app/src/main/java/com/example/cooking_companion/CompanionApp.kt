package com.example.cooking_companion

import androidx.annotation.StringRes
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.cooking_companion.ui.CompanionHomeScreen
import com.example.cooking_companion.ui.CompanionSearchScreen


enum class CompanionScreen(val route: String){
    Home("home"),
    Search("search")
}



@Composable
fun CompanionApp(
    modifier: Modifier = Modifier,
) {
    val navController = rememberNavController()
    Scaffold(
        bottomBar = {
            BottomNavbar(navController)
        }
    ) { innerPadding ->
        NavHost(navController, startDestination = CompanionScreen.Home.route, Modifier.padding(innerPadding)) {
            composable(CompanionScreen.Home.route) { CompanionHomeScreen() }
            composable(CompanionScreen.Search.route) { CompanionSearchScreen() }

        }
    }
}

@Composable
fun BottomNavbar(navController: NavHostController) {
    NavigationBar {
        val currentDestination = navController.currentDestination?.route
        CompanionScreen.values().forEach { screen ->
            NavigationBarItem(
                icon = { when (screen) {
                    CompanionScreen.Home -> Icon(Icons.Filled.Home, contentDescription = "Home")
                    CompanionScreen.Search -> Icon(Icons.Filled.Search, contentDescription = "Search")
                } },
                label = { Text(screen.name) },
                selected = currentDestination == screen.route,
                onClick = {
                    if (currentDestination != screen.route) {
                        navController.navigate(screen.route)
                    }
                }
            )
        }
    }
}
