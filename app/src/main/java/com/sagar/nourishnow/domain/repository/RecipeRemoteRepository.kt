package com.sagar.nourishnow.domain.repository

import com.sagar.nourishnow.common.Resource
import com.sagar.nourishnow.domain.remote.dto.RecipeDto
import com.sagar.nourishnow.domain.remote.dto.RecipeDtoPost
import kotlinx.coroutines.flow.Flow

interface RecipeRemoteRepository {
    suspend fun getIngredientNutrition(queryMap: Map<String, String>): Flow<Resource<RecipeDto>>
    suspend fun getRecipeNutrition(queryMap: Map<String, String>, recipe: RecipeDtoPost): Flow<Resource<RecipeDto>>
}