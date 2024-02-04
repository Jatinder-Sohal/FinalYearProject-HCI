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
        Bookmark(1,"Chicken Curry", R.drawable.chickencurry_dishes, "1 Hour and 30 Minutes", "Moderate"),
        Bookmark(2,"Chicken Waffles", R.drawable.chickenwaffles_dishes, "1 Hour", "Moderate"),
        Bookmark(3,"Fried Noodles", R.drawable.noodles_dishes, "1 Hour", "Easy"),
        Bookmark(4,"Pumpkin Soup", R.drawable.pumpkinsoup_dishes, "1 Hour 30 Minutes", "Moderate"),
        Bookmark(5, "BBQ Pie", R.drawable.bbqpie_dishes, "2 Hours", "Hard"),

    )
}