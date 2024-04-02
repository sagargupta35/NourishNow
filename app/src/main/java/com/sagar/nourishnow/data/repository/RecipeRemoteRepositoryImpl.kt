package com.sagar.nourishnow.data.repository

import com.sagar.nourishnow.common.Resource
import com.sagar.nourishnow.domain.remote.EdamamApi
import com.sagar.nourishnow.domain.remote.dto.RecipeDto
import com.sagar.nourishnow.domain.remote.dto.RecipeDtoPost
import com.sagar.nourishnow.domain.repository.RecipeRemoteRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject


class RecipeRemoteRepositoryImpl @Inject constructor(
    private val edamamApi: EdamamApi
): RecipeRemoteRepository {
    override suspend fun getIngredientNutrition(queryMap: Map<String, String>): Flow<Resource<RecipeDto>> = flow {
        emit(Resource.Loading("Fetching the requested ingredient"))
        try{
            val recipe = edamamApi.getIngredientNutrition(queryMap)
            emit(Resource.Success(recipe))
        } catch (e: HttpException) {
            emit(Resource.Error(e.localizedMessage ?: "Unexpected error in RecipeRepository"))
        } catch (e: IOException) {
            emit(Resource.Error("Check your internet Connection"))
        } catch (e: IllegalArgumentException) {
            emit(Resource.Error(msg = e.localizedMessage ?: "Unexpected error in RecipeRepository"))
        }
    }

    override suspend fun getRecipeNutrition(
        queryMap: Map<String, String>,
        recipe: RecipeDtoPost
    ): Flow<Resource<RecipeDto>> = flow {
        emit(Resource.Loading("Fetching the requested Recipe"))
        try{
            val recipeDto = edamamApi.getRecipeNutrition(recipe, queryMap)
            emit(Resource.Success(recipeDto))
        } catch (e: HttpException) {
            emit(Resource.Error(e.localizedMessage ?: "Unexpected error in RecipeRepository"))
        } catch (e: IOException) {
            emit(Resource.Error("Check your internet Connection"))
        } catch (e: IllegalArgumentException) {
            emit(Resource.Error(msg = e.localizedMessage ?: "Unexpected error in RecipeRepository"))
        }
    }
}