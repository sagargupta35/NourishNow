package com.sagar.nourishnow.domain.model

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.sagar.nourishnow.data.offline.model.CalorieStatsOffline
import com.sagar.nourishnow.data.offline.model.IngredientOffline
import com.sagar.nourishnow.data.offline.model.MajorNutrientOffline
import com.sagar.nourishnow.data.offline.model.NutrientOffline
import com.sagar.nourishnow.data.offline.model.NutrientsKcalOffline
import com.sagar.nourishnow.data.offline.model.RecipeOffline
import kotlinx.coroutines.flow.*
import java.util.Date


@Dao
interface RecipeDao {
    @Insert
    suspend fun addNutrient(nutrientOffline: NutrientOffline)

    @Insert
    suspend fun addMajorNutrient(majorNutrientOffline: MajorNutrientOffline)

    @Insert
    suspend fun addIngredient(ingredientOffline: IngredientOffline)

    @Insert
    suspend fun addRecipe(recipeOffline: RecipeOffline)

    @Update
    suspend fun updateIngredient(ingredientOffline: IngredientOffline)

    @Update
    suspend fun updateRecipe(recipeOffline: RecipeOffline)

    @Delete
    suspend fun deleteRecipe(recipe: RecipeOffline)

    @Delete
    suspend fun deleteIngredient(ingredientOffline: IngredientOffline)

    @Query("SELECT * FROM NutrientOffline WHERE majorNutrientId = :majorNutrientId")
    fun getNutrientByMajorNutrientId(majorNutrientId: Int): Flow<List<NutrientOffline>>

    @Query("SELECT * FROM MajorNutrientOffline WHERE recipeId = :recipeId")
    fun getMajorNutrientByRecipeId(recipeId: Int): Flow<List<MajorNutrientOffline>>

    @Query("SELECT * FROM MajorNutrientOffline WHERE ingredientId = :ingredientId")
    fun getMajorNutrientByIngredientId(ingredientId: Int): Flow<List<MajorNutrientOffline>>

    @Query("SELECT * FROM IngredientOffline WHERE recipeId = :recipeId")
    fun getIngredientByRecipeId(recipeId: Int): Flow<List<IngredientOffline>>

    @Query("SELECT * FROM IngredientOffline WHERE ingredientId = :ingredientId")
    fun getIngredientById(ingredientId: Int): Flow<IngredientOffline>

    @Query("SELECT * FROM RecipeOffline WHERE recipeId = :recipeId")
    fun getRecipeById(recipeId: Int): Flow<RecipeOffline>

    @Query("SELECT * FROM CalorieStatsOffline WHERE date = :date")
    fun getCalorieStatsByDate(date: Date): Flow<CalorieStatsOffline>

    @Query("SELECT * FROM NutrientsKcalOffline WHERE date = :date")
    fun getNutrientKcalByDate(date: Date): Flow<NutrientsKcalOffline>


}