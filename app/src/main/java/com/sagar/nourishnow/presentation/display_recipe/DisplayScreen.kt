package com.sagar.nourishnow.presentation.display_recipe

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.sagar.nourishnow.domain.model.IngredientItem
import com.sagar.nourishnow.domain.model.MajorNutrient
import com.sagar.nourishnow.presentation.display_recipe.common.IngredientItemCard
import com.sagar.nourishnow.presentation.display_recipe.common.RecipeNutritionCard


@Composable
fun DisplayRecipeScreen(
    displayRecipeViewModel: DisplayRecipeViewModel = hiltViewModel(),
    displayRecipeUiState: DisplayRecipeUiState = displayRecipeViewModel.displayRecipeUiState,
    navigateOnError: () -> Unit,
    navigateToDisplayRecipeScreen: (String) -> Unit,
    refreshHomeScreen: () -> Unit,
    navigateUp: () -> Unit
) {
    if(displayRecipeUiState.hasError){
        displayRecipeViewModel.clearUiState()
        navigateOnError()
    }
    Box(modifier = Modifier.fillMaxSize()){
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            if(displayRecipeUiState.showDeleteRecipeDialogueBox &&
                !displayRecipeUiState.isLoading &&
                displayRecipeUiState.recipeId != null){
                DeleteRecipeDialogueBox(
                    onCancelClick = {
                        displayRecipeViewModel.hideDisplayRecipeDialogueBox()
                    },
                    onDeleteClick = {
                        displayRecipeViewModel.deleteRecipe(
                            it,
                            refreshHomeScreen = refreshHomeScreen,
                            navigateUp = navigateUp
                        )
                    },
                    recipeId = displayRecipeUiState.recipeId
                )
            }
        }
        if(displayRecipeUiState.isLoading){
            Column(
                modifier = Modifier
                   .fillMaxSize(),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                CircularProgressIndicator()
            }
        } else {
            LazyColumn(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 12.dp, horizontal = 16.dp),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                item {
                    Text(
                        text =
                        if (displayRecipeUiState.name.length > 30) displayRecipeUiState.name.take(30) + "..."
                        else displayRecipeUiState.name,
                        fontSize = 32.sp,
                        fontWeight = FontWeight.Bold
                    )
                    displayRecipeUiState.ingredientItemList.forEach {
                        Spacer(modifier = Modifier.height(8.dp))
                        IngredientItemCard(
                            ingredientItem = it,
                            onClick = { ingredientId ->
                                displayRecipeViewModel.onIngredientItemClick(
                                    ingredientId = ingredientId,
                                    navigateToDisplayRecipeScreen = navigateToDisplayRecipeScreen
                                )
                            }
                        )
                    }
                    Spacer(modifier = Modifier.height(12.dp))
                    RecipeNutritionCard(
                        amountPerServing = displayRecipeUiState.amountPerServing?.toString(),
                        calories = displayRecipeUiState.calories,
                        majorNutrients = displayRecipeUiState.majorNutrientList,
                    )
                    Spacer(modifier = Modifier.height(12.dp))
                    if(displayRecipeUiState.isRecipe) {
                        Button(
                            onClick = {
                                displayRecipeViewModel.showDisplayRecipeDialogueBox()
                            },
                            shape = RoundedCornerShape(12.dp),
                            modifier = Modifier.fillMaxWidth()
                        ) {
                            Text(
                                text = "Delete Recipe",
                                fontSize = 20.sp
                            )
                        }
                        Spacer(modifier = Modifier.height(12.dp))
                    }
                }
            }
        }
    }
}

@Preview
@Composable
fun DeleteRecipeDialogueBox(
    onCancelClick: ()-> Unit = {},
    onDeleteClick: (Long) -> Unit = {},
    recipeId: Long = 0,
) {
    AlertDialog(onDismissRequest = onCancelClick,
        modifier = Modifier
            .fillMaxWidth(),
        confirmButton = {
            Button(
                onClick = {
                    onDeleteClick(recipeId)
                }
            ){
                Text(text = "Delete",
                    fontSize = 16.sp
                )
            }
        },
        dismissButton = {
            OutlinedButton(
                onClick = onCancelClick
            ) {
                Text(text = "Cancel",
                    fontSize = 16.sp
                )
            }
        },
        title = {
            Text(text = "Delete")
        },
        text = {
            Text(text = "Do you want to delete this recipe?",
                fontSize = 16.sp
            )
        }
    )
}