package com.example.cooking_companion.data

import com.example.cooking_companion.R

object DataSource {
    val categoriesList = listOf(
        Category("Meatless", R.drawable.simple_cat),
        Category("Courses", R.drawable.course_cat),
        Category("Diets", R.drawable.diet_cat),
        Category("Healthy", R.drawable.healthy_cat),
        Category("Asian", R.drawable.asian_cat),
        Category("Asians", R.drawable.asian_cat),
    )

    val recipesList = listOf(
        Recipe("Chicken Curry", R.drawable.chickencurry_dishes),
        Recipe("Grilled Cheese", R.drawable.grilledcheese_dishes),
        Recipe("Fried Noodles", R.drawable.noodles_dishes),
        Recipe("BBQ Pie", R.drawable.bbqpie_dishes),
        Recipe("Pumpkin Soup", R.drawable.pumpkinsoup_dishes),
        Recipe("Chicken Waffles ", R.drawable.chickenwaffles_dishes),
    )
}