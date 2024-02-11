package com.example.cooking_companion.data

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
        Recipe("Chicken Curry", R.drawable.chickencurry_dishes),
        Recipe("Grilled Cheese", R.drawable.grilledcheese_dishes),
        Recipe("Fried Noodles", R.drawable.noodles_dishes),
        Recipe("BBQ Pie", R.drawable.bbqpie_dishes),
        Recipe("Pumpkin Soup", R.drawable.pumpkinsoup_dishes),
        Recipe("Chicken Waffles", R.drawable.chickenwaffles_dishes),
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
    val collections = listOf(
        Collection("list1", 0),
        Collection("list2", 0),
        Collection("list3", 0),
        Collection("list4", 0),
    )
}