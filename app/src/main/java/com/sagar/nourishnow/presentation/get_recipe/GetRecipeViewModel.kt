package com.sagar.nourishnow.presentation.get_recipe

import android.util.Log
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.sagar.nourishnow.common.Constants
import com.sagar.nourishnow.common.Resource
import com.sagar.nourishnow.domain.model.Recipe
import com.sagar.nourishnow.domain.remote.dto.RecipeDto
import com.sagar.nourishnow.domain.remote.dto.RecipeDtoPost
import com.sagar.nourishnow.domain.repository.RecipeRemoteRepository
import com.sagar.nourishnow.presentation.get_recipe.common.GetRecipeUiEvent
import com.sagar.nourishnow.presentation.get_recipe.use_case.AddRecipeUseCase
import com.sagar.nourishnow.presentation.get_recipe.use_case.GetRecipeByDtoUseCase
import com.sagar.nourishnow.presentation.get_recipe.use_case.GetRecipeByNameUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import java.time.LocalDate
import java.util.Date
import javax.inject.Inject

@HiltViewModel
class GetRecipeViewModel @Inject constructor(
    private val addRecipeUseCase: AddRecipeUseCase,
    private val getRecipeByNameUseCase: GetRecipeByNameUseCase,
    private val getRecipeByDtoUseCase: GetRecipeByDtoUseCase
): ViewModel() {

    private var _getRecipeUiState = mutableStateOf(GetRecipeUiState())
    var getRecipeUiState: State<GetRecipeUiState> = _getRecipeUiState

    fun uiEvent(event: GetRecipeUiEvent){
        when (event) {
            is GetRecipeUiEvent.RecipeNameChange -> {
                _getRecipeUiState.value = _getRecipeUiState.value.copy(
                    recipeName = event.name,
                    canGetRecipe = event.name.isNotBlank()
                )
            }

            is GetRecipeUiEvent.RecipePostNameChange -> {
                _getRecipeUiState.value = _getRecipeUiState.value.copy(
                    recipeDtoPost = _getRecipeUiState.value.recipeDtoPost.copy(title = event.name),
                    canPostRecipe = event.name.isNotBlank()
                )
            }

            is GetRecipeUiEvent.AddIngredient -> {
                _getRecipeUiState.value =
                    _getRecipeUiState.value.copy(
                        recipeDtoPost =
                        _getRecipeUiState.value.recipeDtoPost.copy(
                            ingredients = if (getRecipeUiState.value.addIngredientDialogueBoxValue.isNotEmpty()) {
                                _getRecipeUiState.value.recipeDtoPost.ingredients.plus(
                                    getRecipeUiState.value.addIngredientDialogueBoxValue
                                )
                            } else _getRecipeUiState.value.recipeDtoPost.ingredients,
                        ),
                        addIngredientDialogueBoxValue = "",
                        showAddIngredientDialogueBox = false,
                    )

            }

            is GetRecipeUiEvent.DeleteIngredient -> {
                _getRecipeUiState.value =
                    _getRecipeUiState.value.copy(
                        recipeDtoPost =
                        _getRecipeUiState.value.recipeDtoPost.copy(
                            ingredients =
                            _getRecipeUiState.value.recipeDtoPost.ingredients.minus(event.name)
                        )
                    )
            }

            is GetRecipeUiEvent.SummaryChange -> {
                _getRecipeUiState.value =
                    _getRecipeUiState.value.copy(
                        recipeDtoPost =
                        _getRecipeUiState.value.recipeDtoPost.copy(
                            summary = event.summary
                        )
                    )
            }

            is GetRecipeUiEvent.YieldChange -> {
                _getRecipeUiState.value = _getRecipeUiState.value.copy(
                    recipeDtoPost = _getRecipeUiState.value.recipeDtoPost.copy(yield = event.yield)
                )
            }

            is GetRecipeUiEvent.TimeChange -> {
                _getRecipeUiState.value = _getRecipeUiState.value.copy(
                    recipeDtoPost = _getRecipeUiState.value.recipeDtoPost.copy(time = event.time)
                )
            }

            is GetRecipeUiEvent.PrepChange -> {
                _getRecipeUiState.value = _getRecipeUiState.value.copy(
                    recipeDtoPost = _getRecipeUiState.value.recipeDtoPost.copy(prep = event.prep)
                )
            }

            is GetRecipeUiEvent.GetRecipe -> {
                getRecipe(
                    event.showLoading,
                    event.addRecipe
                )
            }

            is GetRecipeUiEvent.PostRecipe -> {
                postRecipe(
                    showLoading = event.showLoading,
                    addRecipe = {
                        addRecipe(
                            resource = it,
                            date = event.date,
                            recipeName = event.recipeName,
                            updateRecipe = event.addRecipe
                        )
                    }
                )
            }

            is GetRecipeUiEvent.ClearUiState -> {
                clearUiState()
            }

            is GetRecipeUiEvent.AddIngredientDialogueBoxNameChange -> {
                _getRecipeUiState.value = _getRecipeUiState.value.copy(
                    addIngredientDialogueBoxValue = event.name
                )
            }

            is GetRecipeUiEvent.CloseAddIngredientDialogueBox -> {
                _getRecipeUiState.value = _getRecipeUiState.value.copy(
                    addIngredientDialogueBoxValue = "",
                    showAddIngredientDialogueBox = false
                )
            }

            is GetRecipeUiEvent.ShowAddIngredientDialogueBox -> {
                _getRecipeUiState.value = _getRecipeUiState.value.copy(
                    showAddIngredientDialogueBox = true
                )
            }
            is GetRecipeUiEvent.ShowLoading -> {
                _getRecipeUiState.value = _getRecipeUiState.value.copy(
                    isLoading = true
                )
            }
            is GetRecipeUiEvent.HideLoading -> {
                _getRecipeUiState.value = _getRecipeUiState.value.copy(
                    isLoading = false
                )
            }
            else -> {

            }
        }
    }

    private fun getRecipe(
        showLoading: () -> Unit,
        addRecipe: (Resource<Recipe>) -> Unit
    ) {
        if (getRecipeUiState.value.canGetRecipe) {
            viewModelScope.launch {
                getRecipeByNameUseCase.getRecipeByName(
                    showLoading = showLoading,
                    addRecipe = {

                    },
                    name = getRecipeUiState.value.recipeName
                )
            }
        } else {
            _getRecipeUiState.value = _getRecipeUiState.value.copy(
                hasError = true,
                errorMessage = "Recipe Name is required"
            )
        }
    }

    private fun addRecipe(
        resource: Resource<RecipeDto>,
        date: LocalDate,
        recipeName: String,
        updateRecipe: (Resource<Recipe>) -> Unit
    ){
        if(resource is Resource.Success && resource.data != null){
            viewModelScope.launch {
                addRecipeUseCase.addRecipe(
                    resource.data,
                    date = date,
                    recipeName = recipeName,
                    updateRecipe = updateRecipe
                )
            }
        } else{
            _getRecipeUiState.value = _getRecipeUiState.value.copy(
                isLoading = false,
                hasError = true,
                errorMessage = resource.msg ?: "Unable to fetch recipe"
            )
        }
    }

    private fun postRecipe(
        showLoading: () -> Unit,
        addRecipe: (Resource<RecipeDto>) -> Unit
    ) {
        if (getRecipeUiState.value.canPostRecipe) {
            viewModelScope.launch {
                getRecipeByDtoUseCase.getRecipeByDtoUseCase(
                    showLoading = showLoading,
                    addRecipe = addRecipe,
                    recipePostDto = getRecipeUiState.value.recipeDtoPost
                )
            }
        } else {
            _getRecipeUiState.value = _getRecipeUiState.value.copy(
                hasError = true,
                errorMessage = "Recipe Name is required"
            )
        }
    }

    private fun clearUiState() {
        _getRecipeUiState.value = GetRecipeUiState()
    }

}

data class GetRecipeUiState(
    val recipeName: String = "",
    val canGetRecipe: Boolean = false,
    val recipeDtoPost: RecipeDtoPost = RecipeDtoPost(),
    val canPostRecipe: Boolean = false,
    val hasError: Boolean = false,
    val errorMessage: String = "Unknown Error",
    val isLoading: Boolean = false,
    val showAddIngredientDialogueBox: Boolean = false,
    val addIngredientDialogueBoxValue: String = ""
)
