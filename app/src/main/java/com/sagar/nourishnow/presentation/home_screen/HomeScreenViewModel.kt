package com.sagar.nourishnow.presentation.home_screen

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.sagar.nourishnow.domain.model.CalorieStats
import com.sagar.nourishnow.domain.model.NutrientsKcal
import com.sagar.nourishnow.presentation.home_screen.common.HomeScreenUiEvent
import java.time.LocalDate


class HomeScreenViewModel: ViewModel() {

    var _homeScreenUiState by mutableStateOf(HomeScreenUiState())
        private set

    init{

    }

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
                _homeScreenUiState = _homeScreenUiState.copy(
                    openAddRecipeDialogue = false,
                    openGetRecipeDialogueBox = false,
                    recipeName = ""
                )
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
    val recipeName: String = "",
    val calorieStats: CalorieStats = CalorieStats(
        date = LocalDate.now(),
        calorieLimit = 2000,
        caloriesConsumed = 0,
    ),
    val nutrientsKcal: NutrientsKcal = NutrientsKcal(
        date = LocalDate.now(),
        carbohydrates = 0.0,
        energy = 0.0,
        fat = 0.0,
        protein = 0.0
    ),

)