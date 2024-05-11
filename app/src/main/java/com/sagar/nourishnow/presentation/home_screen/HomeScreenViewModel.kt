package com.sagar.nourishnow.presentation.home_screen

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.sagar.nourishnow.common.Resource
import com.sagar.nourishnow.domain.model.CalorieStats
import com.sagar.nourishnow.domain.model.NutrientsKcal
import com.sagar.nourishnow.domain.model.Recipe
import com.sagar.nourishnow.domain.model.RecipeItem
import com.sagar.nourishnow.presentation.common.Routes
import com.sagar.nourishnow.presentation.home_screen.common.HomeScreenUiEvent
import com.sagar.nourishnow.presentation.home_screen.use_case.CollectRecipeByIdUseCase
import com.sagar.nourishnow.presentation.home_screen.use_case.InitiateAppDetailsUseCase
import com.squareup.moshi.JsonAdapter
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import java.time.LocalDate
import javax.inject.Inject

@HiltViewModel
class HomeScreenViewModel @Inject constructor(
    private val initiateAppDetailsUseCase: InitiateAppDetailsUseCase,
    private val collectRecipeByIdUseCase: CollectRecipeByIdUseCase,
    private val recipeJsonAdapter: JsonAdapter<Recipe>
): ViewModel() {

    var homeScreenUiState by mutableStateOf(HomeScreenUiState())
        private set

    init{
        initiateApp()
    }

    private fun initiateApp(){
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
            homeScreenUiState = homeScreenUiState.copy(
                refresh = false
            )
        }
    }

    private fun onRecipeItemClick(
        id: Long,
        navigateToDisplayRecipeScreen: (String) -> Unit
    ) {
        viewModelScope.launch {
            collectRecipeByIdUseCase.collectRecipeById(
                id
            ){
                homeScreenUiState = homeScreenUiState.copy(isLoading = true)
                if(it is Resource.Success && it.data != null){
                    val recipe = it.data
                    val calories = (recipe.carbohydrateKcal + recipe.proteinKcal + recipe.fatKcal).toInt()

                    val recipeRoute = Routes.getDisplayRecipeScreenRoute(
                        name = recipe.name,
                        recipeId = recipe.recipeId,
                        recipeJsonAdapter.toJson(recipe),
                        calories = calories,
                        amountPerServing = recipe.yield,
                        isRecipe = true
                    )
                    homeScreenUiState = homeScreenUiState
                        .copy(
                            isLoading = false
                        )
                    navigateToDisplayRecipeScreen(recipeRoute)
                } else{
                    homeScreenUiState = homeScreenUiState.copy(
                        isLoading = false,
                        hasError = true,
                        errorMessage = it.msg ?: "Unable to Get Recipe Details"
                    )
                }
            }
        }
    }

    fun refreshScreen(){
        homeScreenUiState = homeScreenUiState.copy(
            refresh = true
        )
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
            is HomeScreenUiEvent.InitiateApp -> {
                initiateApp()
            }
            is HomeScreenUiEvent.RecipeItemClick -> {
                onRecipeItemClick(
                    id = event.recipeId,
                    navigateToDisplayRecipeScreen = event.navigateToDisplayRecipeScreen
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
    val isLoading: Boolean = false,
    val refresh: Boolean = false,
    val hasError: Boolean = false,
    val errorMessage: String = ""
)