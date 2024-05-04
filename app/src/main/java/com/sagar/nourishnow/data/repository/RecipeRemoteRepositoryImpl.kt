package com.sagar.nourishnow.data.repository

import com.sagar.nourishnow.common.Resource
import com.sagar.nourishnow.domain.remote.EdamamApi
import com.sagar.nourishnow.domain.remote.dto.RecipeDto
import com.sagar.nourishnow.domain.remote.dto.RecipeDtoPost
import com.sagar.nourishnow.domain.repository.RecipeRemoteRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject


class RecipeRemoteRepositoryImpl @Inject constructor(
    private val edamamApi: EdamamApi
): RecipeRemoteRepository {
    override suspend fun getIngredientNutrition(queryMap: Map<String, String>): Flow<Resource<RecipeDto>> = flow {
        emit(Resource.Loading("Fetching the requested ingredient"))
        val recipe = edamamApi.getIngredientNutrition(queryMap)
        emit(Resource.Success(recipe))
    }.catch { error ->
        when(error){
            is IOException -> emit(Resource.Error("Check your internet Connection"))
            is HttpException -> emit(Resource.Error(error.localizedMessage?: "Unexpected error in RecipeRepository"))
            else -> emit(Resource.Error(msg = error.localizedMessage?: "Unexpected error in RecipeRepository"))
        }
    }

    override suspend fun getRecipeNutrition(
        queryMap: Map<String, String>,
        recipe: RecipeDtoPost
    ): Flow<Resource<RecipeDto>> = flow {
        emit(Resource.Loading("Fetching the requested Recipe"))
        val recipeDto = edamamApi.getRecipeNutrition(recipe, queryMap)
        emit(Resource.Success(recipeDto))
    }.catch { error ->
        when (error) {
            is IOException -> emit(Resource.Error("Check your internet Connection"))
            is HttpException -> emit(Resource.Error(error.localizedMessage?: "Unexpected error in RecipeRepository"))
            else -> emit(Resource.Error(msg = error.localizedMessage?: "Unexpected error in RecipeRepository"))
        }
    }
    
}