package com.sagar.nourishnow.presentation.home_screen

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.sagar.nourishnow.common.Resource
import com.sagar.nourishnow.domain.model.CalorieStats
import com.sagar.nourishnow.domain.model.NutrientsKcal
import com.sagar.nourishnow.domain.model.RecipeItem
import com.sagar.nourishnow.presentation.home_screen.common.HomeScreenUiEvent
import com.sagar.nourishnow.presentation.home_screen.use_case.InitiateAppDetailsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import java.time.LocalDate
import javax.inject.Inject

@HiltViewModel
class HomeScreenViewModel @Inject constructor(
    private val initiateAppDetailsUseCase: InitiateAppDetailsUseCase
): ViewModel() {

    var homeScreenUiState by mutableStateOf(HomeScreenUiState())
        private set

    init{
        viewModelScope.launch {
            initiateAppDetailsUseCase.initiateApp(
                updateCalorieStats = {
                    if(it is Resource.Success && it.data != null) {
                        homeScreenUiState = homeScreenUiState.copy(
                            calorieStats = it.data
                        )
                    }
                },
                updateNutrientsKcal = {
                    if(it is Resource.Success && it.data != null) {
                        homeScreenUiState = homeScreenUiState.copy(
                            nutrientsKcal = it.data
                        )
                    }
                },
                addRecipes = {
                    if(it is Resource.Success && it.data != null){
                        homeScreenUiState = homeScreenUiState.copy(
                            recipeItemsList = it.data
                        )
                    }
                },
                LocalDate.now(),
                showLoading ={
                    homeScreenUiState = homeScreenUiState.copy(
                        isLoading = true
                    )
                },
                hideLoading = {
                    homeScreenUiState = homeScreenUiState.copy(
                        isLoading = false
                    )
                },
            )
        }
    }

    fun uiEvent(event: HomeScreenUiEvent){
        when (event){
            is HomeScreenUiEvent.AddRecipeClick -> {
                homeScreenUiState = homeScreenUiState.copy(openAddRecipeDialogue = true)
            }
            is HomeScreenUiEvent.CloseAddRecipeDialogue -> {
                homeScreenUiState = homeScreenUiState.copy(
                    openAddRecipeDialogue = false
                )
            }
            is HomeScreenUiEvent.GetRecipeByNameClick -> {
                homeScreenUiState = homeScreenUiState.copy(
                    openAddRecipeDialogue = false,
                    openGetRecipeDialogueBox = true
                )
            }
            is HomeScreenUiEvent.CancelGetRecipeByName -> {
                homeScreenUiState = homeScreenUiState.copy(
                    openAddRecipeDialogue = false,
                    openGetRecipeDialogueBox = false,
                    recipeName = ""
                )
            }
            is HomeScreenUiEvent.UpdateRecipeName -> {
                homeScreenUiState = homeScreenUiState.copy(
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
        caloriesRemaining = 0
    ),
    val nutrientsKcal: NutrientsKcal = NutrientsKcal(
        date = LocalDate.now(),
        carbohydrates = 0.0,
        energy = 0.0,
        fat = 0.0,
        protein = 0.0
    ),
    val recipeItemsList: List<RecipeItem> = listOf(),
    val isLoading: Boolean = false
)