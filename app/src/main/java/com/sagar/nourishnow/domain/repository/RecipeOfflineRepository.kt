package com.sagar.nourishnow.domain.repository

import androidx.room.Query
import com.sagar.nourishnow.common.Resource
import com.sagar.nourishnow.data.offline.model.CalorieStatsOffline
import com.sagar.nourishnow.data.offline.model.IngredientOffline
import com.sagar.nourishnow.data.offline.model.MajorNutrientOffline
import com.sagar.nourishnow.data.offline.model.NutrientOffline
import com.sagar.nourishnow.data.offline.model.NutrientsKcalOffline
import com.sagar.nourishnow.data.offline.model.RecipeOffline
import com.sagar.nourishnow.domain.model.Nutrient
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import java.util.Date


interface RecipeOfflineRepository {
    suspend fun addNutrient(nutrientOffline: NutrientOffline)

    suspend fun addMajorNutrient(majorNutrientOffline: MajorNutrientOffline)

    suspend fun addIngredient(ingredientOffline: IngredientOffline)

    suspend fun addRecipe(recipeOffline: RecipeOffline)

    suspend fun updateIngredient(ingredientOffline: IngredientOffline)

    suspend fun updateRecipe(recipeOffline: RecipeOffline)

    suspend fun deleteRecipe(recipe: RecipeOffline)

    suspend fun deleteIngredient(ingredientOffline: IngredientOffline)

    fun getNutrientByMajorNutrientId(majorNutrientId: Int): Flow<Resource<List<Nutrient>>>

    fun getMajorNutrientByRecipeId(recipeId: Int): Flow<List<MajorNutrientOffline>>

    fun getMajorNutrientByIngredientId(ingredientId: Int): Flow<List<MajorNutrientOffline>>

    fun getIngredientByRecipeId(recipeId: Int): Flow<List<IngredientOffline>>

    fun getIngredientById(ingredientId: Int): Flow<IngredientOffline?>

    fun getRecipeById(recipeId: Int): Flow<RecipeOffline?>

    fun getCalorieStatsByDate(date: Date): Flow<CalorieStatsOffline>

    fun getNutrientKcalByDate(date: Date): Flow<NutrientsKcalOffline>
}