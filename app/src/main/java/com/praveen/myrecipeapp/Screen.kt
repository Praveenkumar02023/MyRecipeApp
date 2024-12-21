package com.praveen.myrecipeapp

sealed class Screen(var route:  String) {
    object RecipeScreen : Screen("recipe_screen")
    object RecipeDetailScreen : Screen("recipe_detail_screen")
}