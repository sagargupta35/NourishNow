package com.sagar.nourishnow.presentation.common

object Routes {
    const val HOME_SCREEN = "home"
    const val POST_RECIPE_SCREEN = "postRecipe"

    // name - name of recipe or ingredient
    // recipeId is id of recipe, it is null for ingredient and it is used to delete recipe if user wants to
    // foodItem is Recipe or Ingredient data class converted into string by moshi
    // calories is the number of calories, it is obtained by summing fat, carb, proteinKcal from the respective data classes
    // amountPerServing is yield which is null for ingredient
    // isRecipe is boolean used to distinguish between Recipe or Ingredient
    const val DISPLAY_RECIPE_SCREEN = "displayScreen/{name}/{recipeId}/{foodItem}/{calories}/{amountPerServing}/{isRecipe}"
    const val ANALYTICS_SCREEN = "analyticsScreen"

    fun getDisplayRecipeScreenRoute(
        name: String,
        recipeId: Long?,
        foodItem: String,
        calories: Int,
        amountPerServing: Int?,
        isRecipe: Boolean
    ): String{
        return buildString {
            append("displayScreen/")
            append("$name/")
            append("$recipeId/")
            append("$foodItem/")
            append("$calories/")
            append("$amountPerServing/")
            append("$isRecipe")
        }
    }
}