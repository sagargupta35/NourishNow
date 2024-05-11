package com.sagar.nourishnow.presentation.home_screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.sagar.nourishnow.presentation.home_screen.common.CalorieStatsCard
import com.sagar.nourishnow.presentation.home_screen.common.HomeScreenUiEvent
import com.sagar.nourishnow.presentation.home_screen.common.NutrientsKcalCard
import com.sagar.nourishnow.presentation.home_screen.common.RecipeItemComposable

@Composable
fun HomeScreen(
    viewModel: HomeScreenViewModel = hiltViewModel(),
    homeScreenUiState: HomeScreenUiState = viewModel.homeScreenUiState,
    navigateToDisplayRecipeScreen: (String) -> Unit
) {
    Box(modifier = Modifier.fillMaxSize()){
        if (homeScreenUiState.refresh) {
            viewModel.uiEvent(HomeScreenUiEvent.InitiateApp)
        }
        if(homeScreenUiState.isLoading){
            Column(
                modifier = Modifier
                    .fillMaxSize(),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                CircularProgressIndicator()
            }
        } else {
            Column(
                modifier = Modifier.fillMaxSize(),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {

                LazyColumn(
                    modifier = Modifier
                        .padding(16.dp)
                ) {
                    item {
                        CalorieStatsCard(
                            calorieStats = homeScreenUiState.calorieStats
                        )
                        Spacer(modifier = Modifier.height(12.dp))
                        NutrientsKcalCard(nutrientsKcal = homeScreenUiState.nutrientsKcal)
                        homeScreenUiState.recipeItemsList.forEach { recipeItem ->
                            Spacer(modifier = Modifier.height(12.dp))
                            RecipeItemComposable(
                                recipeItem = recipeItem
                            ) {recipeId ->
                                viewModel.uiEvent(
                                    HomeScreenUiEvent.RecipeItemClick(
                                        recipeId = recipeId,
                                        navigateToDisplayRecipeScreen = navigateToDisplayRecipeScreen
                                    )
                                )
                            }
                        }
                        Spacer(modifier = Modifier.height(40.dp))
                    }
                }

            }
        }
    }
}