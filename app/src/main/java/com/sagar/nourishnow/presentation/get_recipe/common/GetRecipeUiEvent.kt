package com.sagar.nourishnow.presentation.get_recipe.common

import com.sagar.nourishnow.domain.remote.dto.RecipeDto

sealed class GetRecipeUiEvent {
    data class RecipeNameChange(val name: String): GetRecipeUiEvent()
    data class GetRecipe(
        val showLoading: () -> Unit,
        val addRecipe: (RecipeDto?) -> Unit
    ): GetRecipeUiEvent()
    data class RecipePostNameChange(val name: String): GetRecipeUiEvent()
    data object AddIngredient: GetRecipeUiEvent()
    data class SummaryChange(val summary: String): GetRecipeUiEvent()
    data class YieldChange(val yield: String): GetRecipeUiEvent()
    data class TimeChange(val time: String): GetRecipeUiEvent()
    data class PrepChange(val prep: String): GetRecipeUiEvent()
    data class PostRecipe(
        val showLoading: () -> Unit,
        val addRecipe: (RecipeDto?) -> Unit
    ): GetRecipeUiEvent()

    data object ClearUiState: GetRecipeUiEvent()
    data class DeleteIngredient(val name: String): GetRecipeUiEvent()
    data object ShowAddIngredientDialogueBox: GetRecipeUiEvent()
    data object CloseAddIngredientDialogueBox: GetRecipeUiEvent()
    data class AddIngredientDialogueBoxNameChange(val name: String): GetRecipeUiEvent()
}