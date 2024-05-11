package com.sagar.nourishnow.presentation.home_screen.use_case

import com.sagar.nourishnow.common.Resource
import com.sagar.nourishnow.domain.model.Recipe
import com.sagar.nourishnow.domain.repository.RecipeOfflineRepository
import kotlinx.coroutines.flow.filter
import javax.inject.Inject

class CollectRecipeByIdUseCase @Inject constructor(
    private val recipeOfflineRepository: RecipeOfflineRepository
){
    suspend fun collectRecipeById(
        recipeId: Long,
        onRecipeCollect: (Resource<Recipe>) -> Unit,
    ){
        recipeOfflineRepository.getRecipeById(recipeId)
            .filter { it !is Resource.Loading }
            .collect{
                 onRecipeCollect(it)
            }
    }
}

