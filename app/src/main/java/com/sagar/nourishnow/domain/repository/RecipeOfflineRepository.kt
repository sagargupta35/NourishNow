package com.sagar.nourishnow.domain.repository

import androidx.room.Query
import com.sagar.nourishnow.common.Resource
import com.sagar.nourishnow.data.offline.model.CalorieStatsOffline
import com.sagar.nourishnow.data.offline.model.IngredientOffline
import com.sagar.nourishnow.data.offline.model.MajorNutrientOffline
import com.sagar.nourishnow.data.offline.model.NutrientOffline
import com.sagar.nourishnow.data.offline.model.NutrientsKcalOffline
import com.sagar.nourishnow.data.offline.model.RecipeOffline
import com.sagar.nourishnow.domain.model.CalorieStats
import com.sagar.nourishnow.domain.model.Ingredient
import com.sagar.nourishnow.domain.model.IngredientItem
import com.sagar.nourishnow.domain.model.MajorNutrient
import com.sagar.nourishnow.domain.model.Nutrient
import com.sagar.nourishnow.domain.model.NutrientsKcal
import com.sagar.nourishnow.domain.model.Recipe
import com.sagar.nourishnow.domain.model.RecipeItem
import com.sagar.nourishnow.domain.remote.dto.RecipeDto
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import java.time.LocalDate
import java.util.Date


interface RecipeOfflineRepository {
    suspend fun addRecipe(recipeDto: RecipeDto, date:LocalDate, name:String): Flow<Resource<Recipe>>

    suspend fun deleteRecipe(recipeId: Long)

    fun getIngredientById(ingredientId: Long): Flow<Resource<Ingredient>>

    fun getRecipeById(recipeId: Long): Flow<Resource<Recipe>>

    fun getCalorieStatsByDate(date: LocalDate): Flow<Resource<CalorieStatsOffline>>

    fun getNutrientKcalByDate(date: LocalDate): Flow<Resource<NutrientsKcalOffline>>

    fun getRecipeItemsByDate(date: LocalDate): Flow<Resource<List<RecipeItem>>>

    suspend fun updateNutrientsKcal(nutrientsKcal: NutrientsKcal)

    suspend fun updateCalorieStats(calorieStats: CalorieStats)
}
