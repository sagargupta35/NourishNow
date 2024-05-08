package com.sagar.nourishnow.presentation.get_recipe.use_case

import android.util.Log
import com.sagar.nourishnow.common.Resource
import com.sagar.nourishnow.domain.model.CalorieStats
import com.sagar.nourishnow.domain.model.NutrientsKcal
import com.sagar.nourishnow.domain.model.Recipe
import com.sagar.nourishnow.domain.remote.dto.RecipeDto
import com.sagar.nourishnow.domain.repository.RecipeOfflineRepository
import kotlinx.coroutines.flow.filter
import kotlinx.coroutines.flow.zip
import java.time.LocalDate
import javax.inject.Inject

class AddRecipeUseCase @Inject constructor(
    private val recipeOfflineRepository: RecipeOfflineRepository
) {
    suspend fun addRecipe(
        recipeDto: RecipeDto?,
        recipeName: String,
        date: LocalDate,
        updateRecipe: (Resource<Recipe>) -> Unit,
    ){
        if(recipeDto == null){
            updateRecipe(Resource.Error("Unable to save Recipe"))
        } else{
            recipeOfflineRepository.addRecipe(
                date = date,
                name = recipeName,
                recipeDto = recipeDto
            )
            .filter {
                it !is Resource.Loading
            }
            .zip(
                recipeOfflineRepository.getCalorieStatsByDate(date)
                    .filter { it !is Resource.Loading }
            ){
                calResource, recipeItemResource -> Pair(calResource, recipeItemResource)
            }
            .zip(
                recipeOfflineRepository.getNutrientKcalByDate(date)
                    .filter { it !is Resource.Loading }
            ){
                calResource, recipeItemResource -> Triple(calResource.first, calResource.second, recipeItemResource)
            }
            .collect{
                val recipeResource = it.first
                val calorieStatsResource = it.second
                val nutrientKcalResource = it.third
                if(recipeResource is Resource.Success && calorieStatsResource is Resource.Success && nutrientKcalResource is Resource.Success){
                    if(recipeResource.data != null && calorieStatsResource.data != null && nutrientKcalResource.data != null){
                        updateRecipe(recipeResource)
                        updateCalorieStats(
                            calorieStats = calorieStatsResource.data.toCalorieStats(),
                            date = date,
                            calories = (recipeResource.data.carbohydrateKcal + recipeResource.data.fatKcal + recipeResource.data.proteinKcal).toInt()
                        )
                        updateNutrientsKcal(
                            nutrientsKcal = nutrientKcalResource.data.toNutrientsKcal(),
                            date = date,
                            fatKcal = recipeResource.data.fatKcal,
                            proteinKcal = recipeResource.data.proteinKcal,
                            carbohydrateKcal = recipeResource.data.carbohydrateKcal,
                        )
                    } else{
                        updateRecipe(recipeResource)
                    }
                } else{
                    updateRecipe(recipeResource)
                }
            }
        }
    }

    private suspend fun updateCalorieStats(
        calorieStats: CalorieStats,
        date: LocalDate,
        calories: Int
    ){
        try{
            val updatedCalorieStats = CalorieStats(
                date = date,
                calorieLimit = calorieStats.calorieLimit,
                caloriesConsumed = (calorieStats.caloriesConsumed+calories),
                caloriesRemaining = (calorieStats.caloriesRemaining - calories).coerceAtLeast(0)
            )
            recipeOfflineRepository.updateCalorieStats(updatedCalorieStats)
        } catch (e: Exception){
            Log.d("TAG", e.localizedMessage ?: "Unknown error fetching calorie stats in add recipe use case")
        }
    }

    private suspend fun updateNutrientsKcal(
        nutrientsKcal: NutrientsKcal,
        date: LocalDate,
        carbohydrateKcal: Double,
        fatKcal: Double,
        proteinKcal: Double
    ){
        try{
            val updatedNutrientsKcal = NutrientsKcal(
                carbohydrates = nutrientsKcal.carbohydrates + carbohydrateKcal,
                fat = fatKcal + nutrientsKcal.fat,
                protein = proteinKcal + nutrientsKcal.protein,
                energy = nutrientsKcal.energy + (carbohydrateKcal + fatKcal + proteinKcal),
                date = date
            )
            recipeOfflineRepository.updateNutrientsKcal(updatedNutrientsKcal)
        } catch (e: Exception){
            Log.d("TAG", e.localizedMessage ?: "Unknown error fetching calorie stats in add recipe use case")
        }
    }
}