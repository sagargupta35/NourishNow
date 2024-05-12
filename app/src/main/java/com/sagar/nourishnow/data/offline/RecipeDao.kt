package com.sagar.nourishnow.data.offline

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.sagar.nourishnow.data.offline.model.CalorieStatsOffline
import com.sagar.nourishnow.data.offline.model.IngredientItemOffline
import com.sagar.nourishnow.data.offline.model.IngredientOffline
import com.sagar.nourishnow.data.offline.model.MajorNutrientOffline
import com.sagar.nourishnow.data.offline.model.NutrientOffline
import com.sagar.nourishnow.data.offline.model.NutrientsKcalOffline
import com.sagar.nourishnow.data.offline.model.RecipeItemOffline
import com.sagar.nourishnow.data.offline.model.RecipeOffline
import com.sagar.nourishnow.domain.model.NutrientsKcal
import java.time.LocalDate


@Dao
interface RecipeDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun addNutrient(nutrientOffline: NutrientOffline): Long

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun addRecipeItemOffline(recipeItem: RecipeItemOffline)

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun addMajorNutrient(majorNutrientOffline: MajorNutrientOffline): Long

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun addIngredient(ingredientOffline: IngredientOffline): Long

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun addIngredientItem(ingredientItemOffline: IngredientItemOffline): Long

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun addRecipe(recipeOffline: RecipeOffline): Long

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun addCalorieStats(calorieStatsOffline: CalorieStatsOffline)

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun addNutrientsKcal(nutrientsKcalOffline: NutrientsKcalOffline)

    @Query("SELECT * FROM RecipeItemOffline WHERE date = :date")
    suspend fun getAllRecipeItems(date: LocalDate): List<RecipeItemOffline>

    @Query("DELETE FROM RecipeOffline WHERE recipeId = :recipeId")
    suspend fun deleteRecipe(recipeId: Long)

    @Query("SELECT * FROM NutrientOffline WHERE majorNutrientId = :majorNutrientId")
    suspend fun getNutrientByMajorNutrientId(majorNutrientId: Long): List<NutrientOffline>

    @Query("SELECT * FROM MajorNutrientOffline WHERE recipeId = :recipeId")
    suspend fun getMajorNutrientByRecipeId(recipeId: Long): List<MajorNutrientOffline>

    @Query("SELECT * FROM MajorNutrientOffline WHERE ingredientId = :ingredientId")
    suspend fun getMajorNutrientByIngredientId(ingredientId: Long): List<MajorNutrientOffline>

    @Query("SELECT * FROM IngredientItemOffline WHERE recipeId = :recipeId")
    suspend fun getIngredientItemByRecipeId(recipeId: Long): List<IngredientItemOffline>

    @Query("SELECT * FROM IngredientOffline WHERE ingredientId = :ingredientId")
    suspend fun getIngredientById(ingredientId: Long): IngredientOffline

    @Query("SELECT * FROM RecipeOffline WHERE recipeId = :recipeId")
    suspend fun getRecipeById(recipeId: Long): RecipeOffline

    @Query("SELECT * FROM CalorieStatsOffline WHERE date = :date")
    suspend fun getCalorieStatsByDate(date: LocalDate): CalorieStatsOffline?

    @Query("SELECT * FROM NutrientsKcalOffline WHERE date = :date")
    suspend fun getNutrientKcalByDate(date: LocalDate): NutrientsKcalOffline?

    @Query("SELECT * FROM NutrientsKcalOffline ORDER BY date DESC LIMIT 7")
    suspend fun getWeeklyNutrientsAnalysis(): List<NutrientsKcalOffline>

    @Update
    suspend fun updateNutrientKcal(nutrientsKcal: NutrientsKcalOffline)

    @Update
    suspend fun updateCalorieStats(calorieStats: CalorieStatsOffline)
}