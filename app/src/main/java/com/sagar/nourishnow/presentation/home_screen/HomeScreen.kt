package com.sagar.nourishnow.presentation.home_screen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.FabPosition
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.FloatingActionButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.sagar.nourishnow.presentation.home_screen.common.AddRecipeDialogueBox
import com.sagar.nourishnow.presentation.home_screen.common.HomeScreenUiEvent
import com.sagar.nourishnow.presentation.home_screen.common.RecipeNameAlertBox

@Composable
fun HomeScreen(
    viewModel: HomeScreenViewModel = hiltViewModel(),
    homeScreenUiState: HomeScreenUiState = viewModel.homeScreenUiState,
    onPostRecipeClick:() -> Unit,
) {
    Scaffold(
        floatingActionButton = {
            FloatingActionButton(
                onClick = {
                    viewModel.uiEvent(HomeScreenUiEvent.AddRecipeClick)
                },
                contentColor = Color.White,
                elevation = FloatingActionButtonDefaults.elevation(8.dp),
                modifier = Modifier.padding(16.dp)
            ) {
                Icon(
                    imageVector = Icons.Default.Add,
                    contentDescription = "Add"
                )
            }
        },
        floatingActionButtonPosition = FabPosition.End,
    ) {paddingValues ->
        Column(
            modifier = Modifier
                .padding(paddingValues)
        ) {
            if(homeScreenUiState.openAddRecipeDialogue) {
                AddRecipeDialogueBox(
                    onDismissRequest = {
                        viewModel.uiEvent(HomeScreenUiEvent.CloseAddRecipeDialogue)
                    },
                    height = 250,
                    onGetRecipeClick = {
                        viewModel.uiEvent(HomeScreenUiEvent.GetRecipeByNameClick)
                    },
                    onPostRecipeClick = {
                        viewModel.uiEvent(HomeScreenUiEvent.CloseAddRecipeDialogue)
                        onPostRecipeClick()
                    }
                )
            } else if(homeScreenUiState.openGetRecipeDialogueBox){
                RecipeNameAlertBox(
                    updateRecipeName = {
                        viewModel.uiEvent(HomeScreenUiEvent.UpdateRecipeName(it))
                    },
                    height = 300,
                    getRecipeClick = {

                    },
                    recipeName = homeScreenUiState.recipeName,
                    onDismissRequest = {
                        viewModel.uiEvent(HomeScreenUiEvent.CancelGetRecipeByName)
                    }
                )
            }
        }
    }
}