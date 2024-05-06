package com.sagar.nourishnow.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import com.sagar.nourishnow.presentation.home_screen.HomeScreen
import com.sagar.nourishnow.presentation.home_screen.common.HomeScreenUiEvent
import com.sagar.nourishnow.presentation.home_screen.HomeScreenViewModel
import com.sagar.nourishnow.ui.theme.NourishNowTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            NourishNowTheme {
                // A surface container using the 'background' color from the theme
                val viewModel = HomeScreenViewModel()
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    HomeScreen(
                        addRecipeClick = {
                            viewModel.uiEvent(HomeScreenUiEvent.AddRecipeClick)
                        },
                        closeRecipeClick = {
                            viewModel.uiEvent(HomeScreenUiEvent.CloseAddRecipeDialogue)
                        },
                        homeScreenUiState = viewModel._homeScreenUiState,
                        updateRecipeName = {
                            viewModel.uiEvent(HomeScreenUiEvent.UpdateRecipeName(it))
                        },
                        onGetRecipeClick = {
                            viewModel.uiEvent(HomeScreenUiEvent.GetRecipeByNameClick)
                        },
                        onCancelGetRecipeByName = {
                            viewModel.uiEvent(HomeScreenUiEvent.CancelGetRecipeByName)
                        }
                    )
                }
            }
        }
    }
}
