package com.example.cooking_companion

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Bookmark
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.ReceiptLong
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Settings
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
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.cooking_companion.data.DataSource.recipesList
import com.example.cooking_companion.data.DataSource.tomatoIngredient
import com.example.cooking_companion.data.DataSource.tomatoRecipes
import com.example.cooking_companion.data.DataSource.veganRecipes
import com.example.cooking_companion.ui.pages.NavbarHome
import com.example.cooking_companion.ui.pages.NavbarLists
import com.example.cooking_companion.ui.pages.NavbarSaved
import com.example.cooking_companion.ui.pages.NavbarSearch
import com.example.cooking_companion.ui.pages.NavbarSettings
import com.example.cooking_companion.ui.pages.Collection
import com.example.cooking_companion.ui.pages.RecipeExpanded
import com.example.cooking_companion.ui.pages.SearchResults
import com.example.cooking_companion.ui.pages.Searching


enum class CompanionScreen(val route: String){
    Home("home"),
    Search("search"),
    Saved("saved"),
    Lists("lists"),
    Settings("settings")
}

/**
 * Main composable function for the Cooking Companion app's navigation and layout.
 *
 * Sets up the navigation for the entire app using a bottom navigation bar
 * to switch between different screens like Home, Search, Saved, Lists, and Settings.
 */
@Composable
fun CompanionApp() {
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
            composable(CompanionScreen.Home.route) { NavbarHome(navController) }
            composable(CompanionScreen.Search.route) { NavbarSearch(navController) }
            composable(CompanionScreen.Saved.route) { NavbarSaved(navController) }
            composable(CompanionScreen.Lists.route) { NavbarLists() }
            composable(CompanionScreen.Settings.route) { NavbarSettings() }
            composable(
                route = "savedCollection/{collectionPosts}",
                arguments = listOf(navArgument("collectionPosts"){type = NavType.StringType})
            ) { backStackEntry ->
                Collection(navController, collectionPosts = backStackEntry.arguments?.getString("collectionPosts") ?: "")
            }
            composable("Search"){ Searching(navController)}
            composable(
                route = "Results/{tab}/{searchQuery}",
                arguments = listOf(
                    navArgument("tab"){type = NavType.StringType},
                    navArgument("searchQuery"){type = NavType.StringType})
            ) { backStackEntry ->
            SearchResults(
                navController,
                tab = backStackEntry.arguments?.getString("tab") ?: "",
                query = backStackEntry.arguments?.getString("searchQuery") ?: "")
            }
            composable(
                route = "Recipe/{recipeName}/{listName}",
                arguments = listOf(
                    navArgument("recipeName") { type = NavType.StringType },
                    navArgument("listName") { type = NavType.StringType }
                )
            ) { backStackEntry ->
                val recipeName = backStackEntry.arguments?.getString("recipeName") ?: ""
                val recipe = when (backStackEntry.arguments?.getString("listName") ?: ""){
                    "recipesList" -> recipesList.first { it.name == recipeName }
                    "veganRecipes" -> veganRecipes.first { it.name == recipeName }
                    "tomatoIngredient" -> tomatoIngredient.first{it.name == recipeName}
                    else -> { tomatoRecipes.first{it.name == recipeName}}
                }

                RecipeExpanded(recipe, navController)
            }
        }
    }
}

/**
 * Constructs the bottom navigation bar for the app.
 *
 * @param navController The navigation controller managing app navigation.
 * @param currentRoute The current route string to manage active states of navigation items.
 */
@Composable
fun BottomNavbar(navController: NavHostController, currentRoute: String) {
    NavigationBar{
        CompanionScreen.values().forEach { screen ->
            val selected = currentRoute == screen.route || (currentRoute == "savedCollection/{collectionPosts}" && screen == CompanionScreen.Saved)|| (currentRoute == "Search" && screen == CompanionScreen.Search) || (currentRoute == "Results/{tab}/{searchQuery}" && screen == CompanionScreen.Search)
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
                    indicatorColor = MaterialTheme.colorScheme.surfaceVariant
                )
            )
        }
    }
}

/**
 * Provides the appropriate icon colour for each navigation item.
 *
 * @param selected Boolean indicating if the item is currently selected to choose the icon style.
 * @return A composable that displays the appropriate icon.
 */
@Composable
fun getColor(selected: Boolean): Color {
    return if (selected) {
        Color(0xFFDE6B46)
    }
    else {
        MaterialTheme.colorScheme.inverseSurface
    }
}
