package com.sagar.nourishnow.presentation.add_recipe

import android.util.Log
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.sagar.nourishnow.common.Constants
import com.sagar.nourishnow.common.Resource
import com.sagar.nourishnow.domain.remote.dto.RecipeDto
import com.sagar.nourishnow.domain.remote.dto.RecipeDtoPost
import com.sagar.nourishnow.domain.repository.RecipeRemoteRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class GetRecipeViewModel @Inject constructor(
    private val recipeRemoteRepository: RecipeRemoteRepository
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
                                ingredients =
                                _getRecipeUiState.value.recipeDtoPost.ingredients.plus(event.name)
                    )       )
            }
            is GetRecipeUiEvent.SummaryChange -> {
                _getRecipeUiState.value = _getRecipeUiState.value.copy(recipeDtoPost = _getRecipeUiState.value.recipeDtoPost.copy(summary = event.summary))
            }
            is GetRecipeUiEvent.YieldChange -> {
                _getRecipeUiState.value = _getRecipeUiState.value.copy(recipeDtoPost = _getRecipeUiState.value.recipeDtoPost.copy(yield = event.yield))
            }
            is GetRecipeUiEvent.TimeChange -> {
                _getRecipeUiState.value = _getRecipeUiState.value.copy(recipeDtoPost = _getRecipeUiState.value.recipeDtoPost.copy(time = event.time))
            }
            is GetRecipeUiEvent.PrepChange -> {
                _getRecipeUiState.value = _getRecipeUiState.value.copy(recipeDtoPost = _getRecipeUiState.value.recipeDtoPost.copy(prep = event.prep))
            }
            is GetRecipeUiEvent.GetRecipe -> {
                getRecipe()
            }
            is GetRecipeUiEvent.PostRecipe -> {
                postRecipe()
            }
            else -> {

            }
        }
    }

    private fun getRecipe(){
        Log.d("TAG", "Inside Get Recipe")
        if(getRecipeUiState.value.canGetRecipe){
            val queryMap = mapOf(
                "app_id" to Constants.appId,
                "app_key" to Constants.appKey,
                "nutrition-type" to "cooking",
                "ingr" to getRecipeUiState.value.recipeName
            )
            viewModelScope.launch {
                Log.d("TAG", "Inside ViewModel Scope")
                recipeRemoteRepository.getIngredientNutrition(queryMap)
                    .onEach { resource ->
                        Log.d("TAG", resource.toString())
                        updateUiState(resource)
                    }.collect()
            }
        } else{
            _getRecipeUiState.value = _getRecipeUiState.value.copy(hasError = true, errorMessage = "Recipe Name is required")
        }
    }

    private fun postRecipe(){
        if(getRecipeUiState.value.canPostRecipe){
            val queryMap = mapOf(
                "app_id" to Constants.appId,
                "app_key" to Constants.appKey,
            )
            viewModelScope.launch {
                recipeRemoteRepository.getRecipeNutrition(queryMap, getRecipeUiState.value.recipeDtoPost)
                    .onEach {resource ->
                        updateUiState(resource)
                    }
            }
        } else{
            _getRecipeUiState.value = _getRecipeUiState.value.copy(
                hasError = true,
                errorMessage = "Recipe Name is required"
            )
        }
    }

    private fun updateUiState(resource: Resource<RecipeDto>){
        when(resource){
            is Resource.Loading -> {
                if(!_getRecipeUiState.value.isLoading){
                    Log.d("TAG", "Updating loading to true")
                    _getRecipeUiState.value = _getRecipeUiState.value.copy(isLoading = true)
                }
            }
            is Resource.Success -> {
                if(_getRecipeUiState.value.isLoading){
                    _getRecipeUiState.value = _getRecipeUiState.value.copy(isLoading = false)
                }
                if(resource.data!= null){
                    _getRecipeUiState.value = _getRecipeUiState.value.copy(recipeDto = resource.data)
                } else{
                    _getRecipeUiState.value = _getRecipeUiState.value.copy(hasError = true, errorMessage = "No Recipe Found")
                }
            }
            is Resource.Error -> {
                if(_getRecipeUiState.value.isLoading){
                    _getRecipeUiState.value = _getRecipeUiState.value.copy(isLoading = false)
                }
                _getRecipeUiState.value = _getRecipeUiState.value.copy(
                    hasError = true,
                    errorMessage = resource.msg ?: "Unknown Error Fetching the recipe\uD83D\uDE1E" // sad emoji
                )
            }
        }
    }

    fun clearUiState(){
        _getRecipeUiState.value = GetRecipeUiState()
    }

}

data class GetRecipeUiState(
    val recipeName: String = "",
    val canGetRecipe: Boolean = false,
    val recipeDtoPost: RecipeDtoPost = RecipeDtoPost(),
    val canPostRecipe: Boolean = false,
    val hasError: Boolean = false,
    val errorMessage: String = "No Error",
    val recipeDto: RecipeDto? = null,
    val isLoading: Boolean = false
)
