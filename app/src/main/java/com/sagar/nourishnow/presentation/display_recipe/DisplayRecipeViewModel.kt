package com.sagar.nourishnow.presentation.display_recipe

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.sagar.nourishnow.domain.model.Recipe
import com.sagar.nourishnow.presentation.display_recipe.use_case.AddRecipeUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class DisplayRecipeViewModel @Inject constructor(
    private val addRecipeUseCase: AddRecipeUseCase
): ViewModel() {
    var displayRecipeUiState by mutableStateOf(DisplayRecipeUiState())
        private set

    fun showLoading(){
        if(!displayRecipeUiState.isLoading)
            displayRecipeUiState = displayRecipeUiState.copy(isLoading = true)
    }

    fun hideLoading(){
        displayRecipeUiState = displayRecipeUiState.copy(isLoading = false)
    }

    fun showDisplayRecipeDialogueBox(){
        displayRecipeUiState = displayRecipeUiState.copy(showDeleteRecipeDialogueBox = true)
    }

    fun hideDisplayRecipeDialogueBox(){
        displayRecipeUiState = displayRecipeUiState.copy(showDeleteRecipeDialogueBox = false)
    }

    fun clearUiState(){
        displayRecipeUiState = DisplayRecipeUiState()
    }

}

data class DisplayRecipeUiState(
    val isLoading: Boolean = false,
    val showDeleteRecipeDialogueBox: Boolean = false
)