package com.sagar.nourishnow.presentation.home_screen.use_case

import android.util.Log
import com.sagar.nourishnow.common.Resource
import com.sagar.nourishnow.data.offline.model.CalorieStatsOffline
import com.sagar.nourishnow.data.offline.model.NutrientsKcalOffline
import com.sagar.nourishnow.domain.model.CalorieStats
import com.sagar.nourishnow.domain.model.NutrientsKcal
import com.sagar.nourishnow.domain.model.RecipeItem
import com.sagar.nourishnow.domain.repository.RecipeOfflineRepository
import kotlinx.coroutines.flow.buffer
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.filter
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.flow.zip
import java.time.LocalDate
import javax.inject.Inject

class InitiateAppDetailsUseCase @Inject constructor(
    private val recipeOfflineRepository: RecipeOfflineRepository
){
    suspend fun initiateApp(
        updateCalorieStats: (Resource<CalorieStats>) -> Unit,
        updateNutrientsKcal: (Resource<NutrientsKcal>) -> Unit,
        addRecipes: (Resource<List<RecipeItem>>) -> Unit,
        todayDate: LocalDate,
        showLoading: () -> Unit,
        hideLoading:() -> Unit,
    ){
        showLoading()
        recipeOfflineRepository.getCalorieStatsByDate(todayDate)
            .filter { it !is  Resource.Loading }
            .zip(
                recipeOfflineRepository.getRecipeItemsByDate(todayDate)
                    .filter { it !is Resource.Loading }
            ){
                calResource, recipeItemResource -> Pair(calResource, recipeItemResource)
            }.zip(
                recipeOfflineRepository.getNutrientKcalByDate(todayDate)
                    .filter { it !is Resource.Loading }
            ){
                pair1, nutrientKcal -> Triple(pair1.first, pair1.second, nutrientKcal)
            }.collect{
                handleCalorieStats(updateCalorieStats, todayDate, it.first)
                handleRecipeItems(it.second, addRecipes)
                handleNutrientKcal(it.third, updateNutrientsKcal, todayDate)
                hideLoading()
            }
    }

    private suspend fun handleCalorieStats(
        updateCalorieStats: (Resource<CalorieStats>) -> Unit,
        todayDate: LocalDate,
        resource: Resource<CalorieStatsOffline>
    ){
        when(resource){
            is Resource.Error -> {
                val newCalorieStats = CalorieStatsOffline(
                    date = todayDate,
                    calorieLimit = 2000,
                    caloriesConsumed = 0,
                    caloriesRemaining = 2000
                )
                recipeOfflineRepository.addCalorieStats(newCalorieStats)
                updateCalorieStats(Resource.Success(newCalorieStats.toCalorieStats()))
            }
            is Resource.Success -> {
                if(resource.data != null) {
                    updateCalorieStats(Resource.Success(resource.data.toCalorieStats()))
                } else{
                    updateCalorieStats(Resource.Error(resource.msg ?: "Unable to get Calorie Stats"))
                }
            }
            else -> {

            }
        }
    }

    private fun handleRecipeItems(
        resource: Resource<List<RecipeItem>>,
        addRecipes: (Resource<List<RecipeItem>>) -> Unit,
    ){
        when(resource){
            is Resource.Success -> {
                if(resource.data != null) {
                    addRecipes(Resource.Success(resource.data))
                } else{
                    addRecipes(Resource.Error("Unable to fetch recipes"))
                }
            }
            is Resource.Error -> {
                addRecipes(Resource.Error(resource.msg ?: "No Recipes are added yet"))
            }
            else -> {

            }
        }

    }

    private suspend fun handleNutrientKcal(
        resource: Resource<NutrientsKcalOffline>,
        updateNutrientsKcal: (Resource<NutrientsKcal>) -> Unit,
        todayDate: LocalDate
    ){
        when(resource){
            is Resource.Success -> {
                if(resource.data != null){
                    updateNutrientsKcal(Resource.Success(resource.data.toNutrientsKcal()))
                } else{
                    updateNutrientsKcal(Resource.Error(resource.msg ?: "Unable to get Nutrient  Info"))
                }
            }
            is Resource.Error -> {
                val newNutrientsKcal = NutrientsKcalOffline(
                    date = todayDate,
                    carbohydrates = 0.0,
                    energy = 0.0,
                    fat = 0.0,
                    protein = 0.0
                )
                recipeOfflineRepository.addNutrientsKcal(newNutrientsKcal)
                updateNutrientsKcal(Resource.Success(newNutrientsKcal.toNutrientsKcal()))
            }
            else -> {

            }
        }
    }
}