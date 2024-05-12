package com.sagar.nourishnow.presentation.display_recipe.use_case

import android.util.Log
import com.sagar.nourishnow.common.Resource
import com.sagar.nourishnow.data.offline.model.CalorieStatsOffline
import com.sagar.nourishnow.data.offline.model.NutrientsKcalOffline
import com.sagar.nourishnow.domain.repository.RecipeOfflineRepository
import kotlinx.coroutines.flow.filter
import kotlinx.coroutines.flow.zip
import java.time.LocalDate
import javax.inject.Inject

class DeleteRecipeUseCase @Inject constructor(
    private val recipeOfflineRepository: RecipeOfflineRepository
) {

    suspend fun deleteRecipe(
        recipeId: Long,
        refreshScreen: () -> Unit,
        date: LocalDate,
        carbCal: Double,
        proteinCal: Double,
        fatCal: Double,
        errorMessage: (String?) -> Unit
    ){
        recipeOfflineRepository
            .getCalorieStatsByDate(date)
            .filter { it !is Resource.Loading }
            .zip(
                recipeOfflineRepository.getNutrientKcalByDate(date)
                    .filter { it !is Resource.Loading }
            ) {
                calResource, recipeItemResource -> Pair(calResource, recipeItemResource)
            }.collect{
                if(
                    updateCalorieStats(
                        it.first,
                        calories = (carbCal + proteinCal + fatCal).toInt()
                    ) &&
                    updateNutrientsKcal(
                        it.second,
                        carbCal = carbCal,
                        proteinCal = proteinCal,
                        fatCal = fatCal
                    )
                ){
                    recipeOfflineRepository.deleteRecipe(recipeId = recipeId)
                    refreshScreen()
                } else{
                    errorMessage("Unable to delete recipe")
                }
            }
    }

    private suspend fun updateCalorieStats(
        calResource: Resource<CalorieStatsOffline>,
        calories: Int
    ): Boolean{
        try{
            when(calResource){
                is Resource.Success -> {
                    if(calResource.data != null){
                        val updatedCalorieStats = calResource.data
                            .copy(
                                caloriesConsumed = calResource.data.caloriesConsumed - calories,
                                caloriesRemaining = calResource.data.caloriesRemaining + calories,
                            )
                        recipeOfflineRepository.updateCalorieStats(updatedCalorieStats.toCalorieStats())
                        return true
                    }
                }
                is Resource.Error -> {
                    Log.d("TAG", calResource.msg ?: "Unable to update cal resource in DeleteRecipeUseCase")
                }
                else -> {

                }
            }
            return false
        } catch (e: Exception){
            Log.d("TAG", e.localizedMessage ?: "Unable to update cal resource in DeleteRecipeUseCase")
            return false
        }
    }

    private suspend fun updateNutrientsKcal(
        nutrientKcalResource: Resource<NutrientsKcalOffline>,
        carbCal: Double,
        proteinCal: Double,
        fatCal: Double
    ): Boolean{
        try{
            when(nutrientKcalResource){
                is Resource.Success -> {
                    if(nutrientKcalResource.data != null){
                        val updateNutrientsKcal = nutrientKcalResource.data
                            .copy(
                                carbohydrates = nutrientKcalResource.data.carbohydrates - carbCal,
                                fat = nutrientKcalResource.data.fat - fatCal,
                                protein = nutrientKcalResource.data.protein - proteinCal,
                                energy = nutrientKcalResource.data.energy - (carbCal + proteinCal + fatCal).toInt()
                            )
                        recipeOfflineRepository.updateNutrientsKcal(updateNutrientsKcal.toNutrientsKcal())
                        return true
                    }
                }
                is Resource.Error -> {
                    Log.d("TAG", nutrientKcalResource.msg ?: "Unable to update cal resource in DeleteRecipeUseCase")
                }
                else -> {

                }
            }
            return false
        } catch (e: Exception){
            Log.d("TAG", e.localizedMessage ?: "Unable to update cal resource in DeleteRecipeUseCase")
            return false
        }
    }
}