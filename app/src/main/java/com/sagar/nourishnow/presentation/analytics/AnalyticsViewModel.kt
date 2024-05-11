package com.sagar.nourishnow.presentation.analytics

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.sagar.nourishnow.domain.model.NutrientsKcal
import java.time.LocalDate

class AnalyticsViewModel: ViewModel() {

    var analyticsUiState: AnalyticsUiState by mutableStateOf(AnalyticsUiState())
    private set

}


data class AnalyticsUiState(
    val analyticsData: List<NutrientsKcal> = listOf(
        NutrientsKcal(
            date = LocalDate.now(),
            carbohydrates = 0.toDouble(),
            fat = 0.toDouble(),
            protein = 0.toDouble(),
            energy = 1324.toDouble()
        ),
        NutrientsKcal(
            date = LocalDate.now(),
            carbohydrates = 0.toDouble(),
            fat = 0.toDouble(),
            protein = 0.toDouble(),
            energy = 1875.toDouble()
        ),
        NutrientsKcal(
            date = LocalDate.now(),
            carbohydrates = 0.toDouble(),
            fat = 0.toDouble(),
            protein = 0.toDouble(),
            energy = 1534.toDouble()
        ),
        NutrientsKcal(
            date = LocalDate.now(),
            carbohydrates = 0.toDouble(),
            fat = 0.toDouble(),
            protein = 0.toDouble(),
            energy = 1046.toDouble()
        ),
        NutrientsKcal(
            date = LocalDate.now(),
            carbohydrates = 0.toDouble(),
            fat = 0.toDouble(),
            protein = 0.toDouble(),
            energy = 2130.toDouble()
        ),
        NutrientsKcal(
            date = LocalDate.now(),
            carbohydrates = 0.toDouble(),
            fat = 0.toDouble(),
            protein = 0.toDouble(),
            energy = 1167.toDouble()
        ),
        NutrientsKcal(
            date = LocalDate.now(),
            carbohydrates = 0.toDouble(),
            fat = 0.toDouble(),
            protein = 0.toDouble(),
            energy = 1678.toDouble()
        )
    )
)