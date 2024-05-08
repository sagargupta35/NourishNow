package com.sagar.nourishnow.presentation.get_recipe.use_case

import android.util.Log
import com.sagar.nourishnow.common.Constants
import com.sagar.nourishnow.common.Resource
import com.sagar.nourishnow.domain.remote.dto.RecipeDto
import com.sagar.nourishnow.domain.repository.RecipeRemoteRepository
import javax.inject.Inject

class GetRecipeByNameUseCase @Inject constructor(
    private val recipeRemoteRepository: RecipeRemoteRepository
){
    suspend fun getRecipeByName(
        name: String,
        addRecipe: (Resource<RecipeDto>) -> Unit,
        showLoading: () -> Unit
    ){
        val queryMap = mapOf(
            "app_id" to "764ac739",
            "app_key" to "8a441fd527278dd8472e08092b2ab396",
            "nutrition-type" to "cooking",
            "ingr" to name
        )
        recipeRemoteRepository.getIngredientNutrition(
            queryMap
        ).collect{resource ->
            when(resource){
                is Resource.Loading -> {
                    showLoading()
                }
                is Resource.Error -> {
                    addRecipe(resource)
                    Log.d("TAG", resource.msg ?: "Unknown error fetching recipe")
                }
                is Resource.Success -> {
                    addRecipe(resource)
                }
            }
        }
    }
}