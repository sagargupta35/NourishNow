package com.sagar.nourishnow.presentation.display_recipe

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import com.sagar.nourishnow.domain.model.Ingredient
import com.sagar.nourishnow.domain.model.IngredientItem
import com.sagar.nourishnow.domain.model.MajorNutrient
import com.sagar.nourishnow.domain.model.Recipe
import com.squareup.moshi.JsonAdapter
import com.squareup.moshi.Moshi
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class DisplayRecipeViewModel @Inject constructor(
    private val savedStateHandle: SavedStateHandle,
    private val moshi: Moshi
): ViewModel() {

    private var recipeAdapter: JsonAdapter<Recipe> = moshi.adapter(Recipe::class.java)
    private var ingredientAdapter: JsonAdapter<Ingredient> = moshi.adapter(Ingredient::class.java)
    var displayRecipeUiState: DisplayRecipeUiState by mutableStateOf(DisplayRecipeUiState())

    init{
        try {
            val calories: Int = checkNotNull(savedStateHandle["calories"])
            val name: String = checkNotNull(savedStateHandle["name"])
            val isRecipe: Boolean = checkNotNull(savedStateHandle["isRecipe"])
            if (isRecipe) {
                val recipeId: Long = checkNotNull(savedStateHandle["recipeId"])
                val recipeString: String = checkNotNull(savedStateHandle["foodItem"])
                val recipe: Recipe? = recipeAdapter.fromJson(recipeString)
                val amountPerServing: Int = checkNotNull(savedStateHandle["amountPerServing"])
                displayRecipeUiState = if (recipe == null) {
                    DisplayRecipeUiState(
                        hasError = true
                    )
                } else {
                    DisplayRecipeUiState(
                        name = name,
                        recipeId = recipeId,
                        majorNutrientList = recipe.majorNutrients,
                        ingredientItemList = recipe.ingredients,
                        calories = calories,
                        amountPerServing = amountPerServing,
                        isLoading = false
                    )
                }

            } else {
                val ingredientString: String = checkNotNull(savedStateHandle["foodItem"])
                val ingredient: Ingredient? = ingredientAdapter.fromJson(ingredientString)
                displayRecipeUiState = if(ingredient != null){
                    DisplayRecipeUiState(
                        name = name,
                        majorNutrientList = ingredient.majorNutrients,
                        calories = calories,
                        isLoading = false
                    )
                } else{
                    DisplayRecipeUiState(
                        hasError = true
                    )
                }
            }
        } catch (e: Exception){
            displayRecipeUiState = DisplayRecipeUiState(hasError = true)
        }
    }

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

    fun deleteRecipe(id: Long){

    }

}

data class DisplayRecipeUiState(
    val isLoading: Boolean = true,
    val showDeleteRecipeDialogueBox: Boolean = false,
    val hasError: Boolean = false,
    val name: String = "Unable to Fetch the Name",
    val recipeId: Long? = null,
    val majorNutrientList: List<MajorNutrient> = listOf(),
    val ingredientItemList: List<IngredientItem> = listOf(),
    val calories: Int = 0,
    val amountPerServing: Int? = null
)