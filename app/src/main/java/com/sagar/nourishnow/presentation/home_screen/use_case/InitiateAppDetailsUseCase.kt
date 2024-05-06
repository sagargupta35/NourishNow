package com.sagar.nourishnow.presentation.home_screen.use_case

import com.sagar.nourishnow.domain.model.CalorieStats
import com.sagar.nourishnow.domain.model.NutrientsKcal
import com.sagar.nourishnow.domain.model.Recipe
import com.sagar.nourishnow.domain.repository.RecipeOfflineRepository
import java.time.LocalDate
import javax.inject.Inject

class InitiateAppDetailsUseCase @Inject constructor(
    private val recipeOfflineRepository: RecipeOfflineRepository
) {
    suspend fun initiateApp(
        updateCalorieStats: (CalorieStats) -> Unit,
        updateNutrientsKcal: (NutrientsKcal) -> Unit,
        addRecipe: (Recipe) -> Unit,
        todayDate: LocalDate,
    ){
        recipeOfflineRepository.getCalorieStatsByDate(todayDate)
            .collect{resource ->
                when(resource){

                }

            }
    }
}