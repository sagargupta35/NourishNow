package com.sagar.nourishnow.presentation.analytics.use_case

import com.sagar.nourishnow.common.Resource
import com.sagar.nourishnow.domain.model.NutrientsKcal
import com.sagar.nourishnow.domain.repository.RecipeOfflineRepository
import kotlinx.coroutines.flow.filter
import javax.inject.Inject

class GetWeeklyAnalyticsUseCase @Inject constructor(
    private val recipeOfflineRepository: RecipeOfflineRepository
) {

    suspend fun getWeeklyAnalytics(
        weeklyAnalytics: (Resource<List<NutrientsKcal>>) -> Unit
    ){
        recipeOfflineRepository.getWeeklyNutrientsAnalysis()
           .filter { it !is  Resource.Loading }
            .collect{
                weeklyAnalytics(it)
            }
    }
}