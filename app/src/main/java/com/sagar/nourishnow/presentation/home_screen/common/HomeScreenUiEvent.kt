package com.sagar.nourishnow.presentation.home_screen.common

sealed class HomeScreenUiEvent {
    data object AddRecipeClick: HomeScreenUiEvent()
    data object CloseAddRecipeDialogue: HomeScreenUiEvent()
    data object GetRecipeByNameClick: HomeScreenUiEvent()
    data object CancelGetRecipeByName: HomeScreenUiEvent()
    data class UpdateRecipeName(val name: String): HomeScreenUiEvent()
    data object InitiateApp: HomeScreenUiEvent()
}