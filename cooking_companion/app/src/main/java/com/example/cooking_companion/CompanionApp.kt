package com.example.cooking_companion

import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
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
    val currentRoute = remember { mutableStateOf(CompanionScreen.Home.route) }

    navController.addOnDestinationChangedListener { _, destination, _ ->
        currentRoute.value = destination.route ?: CompanionScreen.Home.route
    }

    Scaffold(
        bottomBar = {
            BottomNavbar(navController, currentRoute.value)
        }
    ) { innerPadding ->
        NavHost(navController, startDestination = CompanionScreen.Home.route, Modifier.padding(innerPadding)) {
            composable(CompanionScreen.Home.route) { CompanionHomeScreen() }
            composable(CompanionScreen.Search.route) { CompanionSearchScreen() }

        }
    }
}

@Composable
fun BottomNavbar(navController: NavHostController, currentRoute: String) {
    NavigationBar {
        CompanionScreen.values().forEach { screen ->
            val selected = currentRoute == screen.route
            NavigationBarItem(
                icon = { when (screen) {
                    CompanionScreen.Home -> {
                        if (selected) Icon(Icons.Filled.Home, contentDescription = "Home", tint=Color(0xFFDE6B46))
                        else Icon(Icons.Outlined.Home, contentDescription = "Home")
                    }
                    CompanionScreen.Search -> {
                        if (selected) Icon(Icons.Filled.Search, contentDescription = "Search", tint=Color(0xFFDE6B46))
                        else Icon(Icons.Outlined.Search, contentDescription = "Search")
                    }
                } },
                label = { Text(screen.name, color = getColor(selected)) },
                selected = selected,
                onClick = {
                    if (!selected) {
                        navController.navigate(screen.route)
                    }
                }
            )
        }
    }
}
@Composable
fun getColor(selected: Boolean): Color {
    return if (selected) {
        Color(0xFFDE6B46)
    }
    else {
        Color(0xFF000000)
    }
}
