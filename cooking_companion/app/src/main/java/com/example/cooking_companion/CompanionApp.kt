package com.example.cooking_companion

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Bookmark
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.ReceiptLong
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.outlined.Bookmark
import androidx.compose.material.icons.outlined.BookmarkBorder
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.ReceiptLong
import androidx.compose.material.icons.outlined.Search
import androidx.compose.material.icons.outlined.Settings
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.cooking_companion.ui.pages.CompanionHomeScreen
import com.example.cooking_companion.ui.pages.CompanionListsScreen
import com.example.cooking_companion.ui.pages.CompanionSavedScreen
import com.example.cooking_companion.ui.pages.CompanionSearchScreen
import com.example.cooking_companion.ui.pages.CompanionSettingsScreen


enum class CompanionScreen(val route: String){
    Home("home"),
    Search("search"),
    Saved("saved"),
    Lists("lists"),
    Settings("settings")
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
            composable(CompanionScreen.Saved.route) { CompanionSavedScreen() }
            composable(CompanionScreen.Lists.route) { CompanionListsScreen() }
            composable(CompanionScreen.Settings.route) { CompanionSettingsScreen() }


        }
    }
}

@Composable
fun BottomNavbar(navController: NavHostController, currentRoute: String, modifier: Modifier = Modifier) {
    NavigationBar{
        CompanionScreen.values().forEach { screen ->
            val selected = currentRoute == screen.route
            NavigationBarItem(
                icon = { when (screen) {
                    CompanionScreen.Home -> {
                        if (selected) Icon(Icons.Filled.Home, contentDescription = "Home", modifier = Modifier.size(32.dp), tint=Color(0xFFDE6B46))
                        else Icon(Icons.Outlined.Home, contentDescription = "Home", modifier = Modifier.size(32.dp))
                    }
                    CompanionScreen.Search -> {
                        if (selected) Icon(Icons.Filled.Search, contentDescription = "Search", modifier = Modifier.size(32.dp), tint=Color(0xFFDE6B46))
                        else Icon(Icons.Outlined.Search, modifier = Modifier.size(32.dp), contentDescription = "Search")
                    }
                    CompanionScreen.Saved -> {
                        if (selected) Icon(Icons.Filled.Bookmark, contentDescription = "Saved", modifier = Modifier.size(32.dp), tint=Color(0xFFDE6B46))
                        else Icon(Icons.Outlined.BookmarkBorder, modifier = Modifier.size(32.dp), contentDescription = "Saved")
                    }
                    CompanionScreen.Lists -> {
                        if (selected) Icon(Icons.Filled.ReceiptLong, contentDescription = "Lists", modifier = Modifier.size(32.dp), tint=Color(0xFFDE6B46))
                        else Icon(Icons.Outlined.ReceiptLong, modifier = Modifier.size(32.dp), contentDescription = "Lists")
                    }
                    CompanionScreen.Settings -> {
                        if (selected) Icon(Icons.Filled.Settings, contentDescription = "Settings", modifier = Modifier.size(32.dp), tint=Color(0xFFDE6B46))
                        else Icon(Icons.Outlined.Settings, modifier = Modifier.size(32.dp), contentDescription = "Settings")
                    }

                } },
                label = { Text(screen.name, color = getColor(selected)) },
                selected = selected,
                onClick = {
                    if (!selected) {
                        navController.navigate(screen.route)
                    }
                },
                colors = NavigationBarItemDefaults.colors(
                    indicatorColor = Color(0xFFDCDCDC)
                )
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
