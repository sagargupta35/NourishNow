package com.sagar.nourishnow.domain.repository

import com.sagar.nourishnow.common.Resource
import com.sagar.nourishnow.data.remote.dto.RecipeDto
import com.sagar.nourishnow.domain.model.Recipe
import kotlinx.coroutines.flow.Flow

interface RecipeRepository {
    suspend fun getIngredientNutrition(queryMap: Map<String, String>): Flow<Resource<RecipeDto>>
    suspend fun getRecipeNutrition(queryMap: Map<String, String>, recipe: Recipe): Flow<Resource<RecipeDto>>
}