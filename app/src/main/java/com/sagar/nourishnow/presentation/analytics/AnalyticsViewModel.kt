package com.sagar.nourishnow.presentation.analytics

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.sagar.nourishnow.common.Resource
import com.sagar.nourishnow.domain.model.NutrientsKcal
import com.sagar.nourishnow.presentation.analytics.use_case.GetWeeklyAnalyticsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import java.time.LocalDate
import javax.inject.Inject


@HiltViewModel
class AnalyticsViewModel @Inject constructor(
    private val getWeeklyAnalyticsUseCase: GetWeeklyAnalyticsUseCase
): ViewModel() {

    var analyticsUiState: AnalyticsUiState by mutableStateOf(AnalyticsUiState())
    private set

    init{
        viewModelScope.launch {
            getWeeklyAnalyticsUseCase.getWeeklyAnalytics {
                analyticsUiState = if(it is Resource.Success && it.data != null){
                    analyticsUiState.copy(
                        analyticsData = it.data,
                        isLoading = false,
                        hasError = false,
                        errorMessage = ""
                    )
                } else{
                    analyticsUiState.copy(
                        isLoading = false,
                        hasError = true,
                        errorMessage = it.msg?: "Unable to get analytics data"
                    )
                }
            }
        }
    }

}


data class AnalyticsUiState(
    val analyticsData: List<NutrientsKcal> = listOf(),
    val isLoading: Boolean = true,
    val hasError: Boolean = false,
    val errorMessage: String = ""
)