package com.sagar.nourishnow.data.repository

import com.sagar.nourishnow.common.Resource
import com.sagar.nourishnow.data.offline.model.CalorieStatsOffline
import com.sagar.nourishnow.data.offline.model.IngredientOffline
import com.sagar.nourishnow.data.offline.model.MajorNutrientOffline
import com.sagar.nourishnow.data.offline.model.NutrientOffline
import com.sagar.nourishnow.data.offline.model.NutrientsKcalOffline
import com.sagar.nourishnow.data.offline.model.RecipeOffline
import com.sagar.nourishnow.domain.model.Nutrient
import com.sagar.nourishnow.domain.model.RecipeDao
import com.sagar.nourishnow.domain.repository.RecipeOfflineRepository
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.filterNotNull
import kotlinx.coroutines.flow.flatMapConcat
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.map
import retrofit2.HttpException
import java.io.IOException
import java.util.Date
import javax.inject.Inject

class RecipeOfflineRepositoryImpl @Inject constructor(
    private val recipeDao: RecipeDao
): RecipeOfflineRepository {
    override suspend fun addNutrient(nutrientOffline: NutrientOffline)  = recipeDao.addNutrient(nutrientOffline)

    override suspend fun addMajorNutrient(majorNutrientOffline: MajorNutrientOffline) = recipeDao.addMajorNutrient(majorNutrientOffline)

    override suspend fun addIngredient(ingredientOffline: IngredientOffline)  = recipeDao.addIngredient(ingredientOffline)

    override suspend fun addRecipe(recipeOffline: RecipeOffline) = recipeDao.addRecipe(recipeOffline)

    override suspend fun updateIngredient(ingredientOffline: IngredientOffline) = recipeDao.updateIngredient(ingredientOffline)

    override suspend fun updateRecipe(recipeOffline: RecipeOffline) = recipeDao.updateRecipe(recipeOffline)

    override suspend fun deleteRecipe(recipe: RecipeOffline) = recipeDao.deleteRecipe(recipe)

    override suspend fun deleteIngredient(ingredientOffline: IngredientOffline) = recipeDao.deleteIngredient(ingredientOffline)

    @OptIn(ExperimentalCoroutinesApi::class)
    override fun getNutrientByMajorNutrientId(majorNutrientId: Int): Flow<Resource<List<Nutrient>>> = flow {
        emit(Resource.Loading("Fetching major nutrients information"))
        try{
            recipeDao.getNutrientByMajorNutrientId(majorNutrientId)
                .collect{list ->
                    emit(
                        Resource.Success(
                            list.map {nutrientOffline -> nutrientOffline.toNutrient()}
                        )
                    )
                }
        } catch(e: Exception) {
            emit(Resource.Error(e.localizedMessage ?: "Error in recipe repo collecting nutrients"))
        }
    }

    override fun getMajorNutrientByRecipeId(recipeId: Int): Flow<List<MajorNutrientOffline>> = recipeDao.getMajorNutrientByRecipeId(recipeId)

    override fun getMajorNutrientByIngredientId(ingredientId: Int): Flow<List<MajorNutrientOffline>> = recipeDao.getMajorNutrientByIngredientId(ingredientId)

    override fun getIngredientByRecipeId(recipeId: Int): Flow<List<IngredientOffline>> = recipeDao.getIngredientByRecipeId(recipeId)

    override fun getIngredientById(ingredientId: Int): Flow<IngredientOffline?> = recipeDao.getIngredientById(ingredientId)

    override fun getRecipeById(recipeId: Int): Flow<RecipeOffline?> = recipeDao.getRecipeById(recipeId)

    override fun getCalorieStatsByDate(date: Date): Flow<CalorieStatsOffline> {
        TODO("Not yet implemented")
    }

    override fun getNutrientKcalByDate(date: Date): Flow<NutrientsKcalOffline> {
        TODO("Not yet implemented")
    }


}
