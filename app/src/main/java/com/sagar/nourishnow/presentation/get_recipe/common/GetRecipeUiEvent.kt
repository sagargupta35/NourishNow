package com.sagar.nourishnow.presentation.get_recipe.common

sealed class GetRecipeUiEvent {
    data class RecipeNameChange(val name: String): GetRecipeUiEvent()
    data object GetRecipe: GetRecipeUiEvent()
    data class RecipePostNameChange(val name: String): GetRecipeUiEvent()
    data class AddIngredient(val name: String): GetRecipeUiEvent()
    data class SummaryChange(val summary: String): GetRecipeUiEvent()
    data class YieldChange(val yield: String): GetRecipeUiEvent()
    data class TimeChange(val time: String): GetRecipeUiEvent()
    data class PrepChange(val prep: String): GetRecipeUiEvent()
    data object PostRecipe: GetRecipeUiEvent()
}