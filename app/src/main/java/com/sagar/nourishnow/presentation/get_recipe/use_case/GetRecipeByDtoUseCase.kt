package com.sagar.nourishnow.presentation.get_recipe.use_case

import android.util.Log
import com.sagar.nourishnow.common.Resource
import com.sagar.nourishnow.domain.remote.dto.RecipeDto
import com.sagar.nourishnow.domain.remote.dto.RecipeDtoPost
import com.sagar.nourishnow.domain.repository.RecipeRemoteRepository
import javax.inject.Inject

class GetRecipeByDtoUseCase @Inject constructor(
    private val recipeRemoteRepository: RecipeRemoteRepository
) {

    suspend fun getRecipeByDtoUseCase(
        recipePostDto: RecipeDtoPost,
        addRecipe: (Resource<RecipeDto>) -> Unit,
        showLoading: () -> Unit,
    ){
        val queryMap = mapOf(
            "app_id" to "764ac739",
            "app_key" to "8a441fd527278dd8472e08092b2ab396",
        )
        recipeRemoteRepository.getRecipeNutrition(
            queryMap,
            recipePostDto
        ).collect{resource ->
            when(resource){
                is Resource.Loading -> {
                    showLoading()
                }
                is Resource.Success -> {
                    addRecipe(resource)
                }
                is Resource.Error -> {
                    addRecipe(resource)
                    Log.d("TAG", resource.msg ?: "Unknown error fetching recipe in GetRecipeByDtoUseCase")
                }
            }
        }
    }
}