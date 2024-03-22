package com.example.cooking_companion.data

import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import com.example.cooking_companion.R

object DataSource {
    val categoriesList = listOf(
        Category("Simple", R.drawable.simple_cat),
        Category("Courses", R.drawable.course_cat),
        Category("Diets", R.drawable.diet_cat),
        Category("Asian", R.drawable.asian_cat),
        Category("Healthy", R.drawable.healthy_cat),
        Category("Main", R.drawable.pizza_cat),
        Category("Desert", R.drawable.cake_cat),
        Category("Vegan", R.drawable.vegan_cat),
        Category("Italian", R.drawable.spaghetti_cat),
    )
    val recipesList = listOf(
        Recipe("Chicken Curry", R.drawable.chickencurry_dishes, true, 100, "Jatinder Sohal"),
        Recipe("Grilled Cheese", R.drawable.grilledcheese_dishes, false, 100, "Jatinder Sohal"),
        Recipe("Fried Noodles", R.drawable.noodles_dishes, false, 100, "Jatinder Sohal"),
        Recipe("BBQ Pie", R.drawable.bbqpie_dishes, false, 100, "Jatinder Sohal"),
        Recipe("Pumpkin Soup", R.drawable.pumpkinsoup_dishes, false, 100, "Jatinder Sohal"),
        Recipe("Chicken Waffles", R.drawable.chickenwaffles_dishes, false, 100, "Jatinder Sohal"),
    )
    val bookmarkedRecipes = listOf(
        Bookmark(8, "BBQ Pie", R.drawable.bbqpie_dishes, "2 Hours 55 Minutes", "Hard"),
        Bookmark(3,"Chicken Curry", R.drawable.chickencurry_dishes, "50 Minutes", "Moderate"),
        Bookmark(4,"Chicken Waffles", R.drawable.chickenwaffles_dishes, "1 Hour", "Hard"),
        Bookmark(5,"Fried Noodles", R.drawable.noodles_dishes, "1 Hour and 10 Minutes", "Easy"),
        Bookmark(0,"Grilled Cheese", R.drawable.grilledcheese_dishes, "15 Minutes", "Easy"),
        Bookmark(1,"Guacamole Salad", R.drawable.guacamolesalad_dishes, "20 Minutes", "Easy"),
        Bookmark(7,"Oreo Sundae", R.drawable.oreosunday_dishes, "2 Hours", "Moderate"),
        Bookmark(2,"Pumpkin Soup", R.drawable.pumpkinsoup_dishes, "45 Minutes", "Moderate"),
        Bookmark(6,"Raspberry Cake", R.drawable.raspberrycake_dishes, "1 Hour 55 Minutes", "Hard"),
    )
    val collections = mutableStateListOf(
        Collection("Collection One", 9, listOf(R.drawable.chickencurry_dishes, R.drawable.grilledcheese_dishes, R.drawable.chickenwaffles_dishes)),
        Collection("12/02/24", 2, listOf(R.drawable.fish_recent, R.drawable.pumpkinsoup_dishes)),
        Collection("List3", 1, listOf(R.drawable.raspberrycake_dishes))
    )
    val recommendations = listOf("Apple", "Apricot", "Apple Crumble", "Banana", "Cherry", "Chicken Soup", "Chicken Curry", "Cheese Pizza", "Date", "Egg fruit", "Fig", "Vegan", "Tomato", "Vegatables", "Toast", "Tiramasu" , "Tacos", "Grapes")
    val tomatoRecipes = mutableListOf(
        Recipe("Chesse and Tomato pizza", R.drawable.chickencurry_dishes, false, 98, "Jatinder Sohal"),
        Recipe("Homemade Tomato Sauce", R.drawable.chickencurry_dishes, false, 935, "Liam Williamson"))
    val veganRecipes = mutableListOf(
        Recipe("Vegan Curry", R.drawable.chickencurry_dishes, false, 87, "Arjun Dhoot"),
        Recipe("Pie (Vegan)", R.drawable.bbqpie_dishes, true, 74, "Carl Smith"),
        Recipe("Cake vegan", R.drawable.raspberrycake_dishes, false, 94, "Bob williams"),
        Recipe("Vegan Waffles ", R.drawable.chickenwaffles_dishes, false, 47, "Shivam Bhalla"),
        Recipe("Vegan Pancakes", R.drawable.pancakes_recent, false, 96, "Omar Mohammed"),
        Recipe("Vegan Noodles", R.drawable.noodles_dishes, false, 27, "Sam Gerab") )

    val tomatoCollection = mutableListOf(
        Collection("No tomato", 3, listOf(R.drawable.oreosunday_dishes, R.drawable.pumpkinsoup_dishes, R.drawable.raspberrycake_dishes)),
        Collection("Use Tomato Sauce", 12, listOf(R.drawable.oreosunday_dishes, R.drawable.pumpkinsoup_dishes, R.drawable.raspberrycake_dishes)))
    val veganCollection = mutableListOf(
        Collection("Vegan Recipes", 6, listOf(R.drawable.oreosunday_dishes, R.drawable.pumpkinsoup_dishes, R.drawable.raspberrycake_dishes)),
        Collection("Quick Vegan", 4, listOf(R.drawable.guacamolesalad_dishes, R.drawable.grilledcheese_dishes, R.drawable.chickenwaffles_dishes)),
        Collection("Main Dish vegan", 8, listOf(R.drawable.pumpkinsoup_dishes, R.drawable.bbqpie_dishes, R.drawable.noodles_dishes)),
        Collection("Vegan easy", 3, listOf(R.drawable.grilledcheese_dishes, R.drawable.chickencurry_dishes,  R.drawable.chickenwaffles_dishes)),
    )
    val tomatoIngredient = mutableListOf(
        Recipe("Fish with a twist", R.drawable.fish_recent, true, 74, "Jatinder Sohal"),
        Recipe("Easy soup", R.drawable.pumpkinsoup_dishes, false, 94, "Jatinder Sohal"),
        Recipe("Chicken Curry", R.drawable.chickencurry_dishes, false, 87, "Jatinder Sohal"),
        Recipe("Saucy Pizza", R.drawable.bbqpie_dishes, false, 47, "Jatinder Sohal")
    )
    val darkMode = mutableStateOf(false)
}