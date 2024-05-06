package com.sagar.nourishnow.presentation.home_screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.FabPosition
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.FloatingActionButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.sagar.nourishnow.R

@Composable
fun HomeScreen(
    addRecipeClick: () -> Unit,
    closeRecipeClick: () -> Unit,
    homeScreenUiState: HomeScreenUiState,
    updateRecipeName: (String) -> Unit,
    onGetRecipeClick: () -> Unit,
    onCancelGetRecipeByName: () -> Unit
) {
    Scaffold(
        floatingActionButton = {
            FloatingActionButton(
                onClick = addRecipeClick,
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
                    onDismissRequest = closeRecipeClick,
                    height = 250,
                    onGetRecipeClick = onGetRecipeClick
                )
            } else if(homeScreenUiState.openGetRecipeDialogueBox){
                RecipeNameAlertBox(
                    updateRecipeName = updateRecipeName,
                    height = 300,
                    getRecipeClick = {  },
                    recipeName = homeScreenUiState.recipeName,
                    onDismissRequest = onCancelGetRecipeByName
                )
            }
        }
    }
}