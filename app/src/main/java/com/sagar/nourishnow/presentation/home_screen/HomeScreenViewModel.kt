package com.sagar.nourishnow.presentation.home_screen

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel


class HomeScreenViewModel: ViewModel() {

    var _homeScreenUiState by mutableStateOf(HomeScreenUiState())
        private set

    fun uiEvent(event: HomeScreenUiEvent){
        when (event){
            is HomeScreenUiEvent.AddRecipeClick -> {
                _homeScreenUiState = _homeScreenUiState.copy(openAddRecipeDialogue = true)
            }
            is HomeScreenUiEvent.CloseAddRecipeDialogue -> {
                _homeScreenUiState = _homeScreenUiState.copy(
                    openAddRecipeDialogue = false
                )
            }
            is HomeScreenUiEvent.GetRecipeByNameClick -> {
                _homeScreenUiState = _homeScreenUiState.copy(
                    openAddRecipeDialogue = false,
                    openGetRecipeDialogueBox = true
                )
            }
            is HomeScreenUiEvent.CancelGetRecipeByName -> {
                _homeScreenUiState = HomeScreenUiState()
            }
            is HomeScreenUiEvent.UpdateRecipeName -> {
                _homeScreenUiState = _homeScreenUiState.copy(
                    recipeName = event.name
                )
            }
            else -> {

            }
        }
    }
}

data class HomeScreenUiState(
    val openAddRecipeDialogue: Boolean = false,
    val openGetRecipeDialogueBox: Boolean = false,
    val recipeName: String = ""
)