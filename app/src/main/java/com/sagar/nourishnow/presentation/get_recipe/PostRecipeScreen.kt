package com.sagar.nourishnow.presentation.get_recipe

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.absolutePadding
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.FloatingActionButton
import androidx.compose.material.FloatingActionButtonDefaults
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Create
import androidx.compose.material3.Button
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import androidx.hilt.navigation.compose.hiltViewModel
import com.sagar.nourishnow.domain.model.Recipe
import com.sagar.nourishnow.presentation.get_recipe.common.AddIngredientDialogueBox
import com.sagar.nourishnow.presentation.get_recipe.common.GetRecipeUiEvent
import com.sagar.nourishnow.presentation.get_recipe.common.IngredientItem


@Composable
fun PostRecipeScreen(
    getRecipeViewModel: GetRecipeViewModel = hiltViewModel(),
    getRecipeUiState: GetRecipeUiState = getRecipeViewModel.getRecipeUiState.value,
    onEvent: (GetRecipeUiEvent) -> Unit = getRecipeViewModel::uiEvent,
    onCancelPostRecipe: () -> Unit,
    takeRecipe: (Recipe) -> Unit
) {
    Scaffold(
        floatingActionButton = {
            FloatingActionButton(
                onClick = {
                    onEvent(GetRecipeUiEvent.ShowGetRecipeByNameDialogueBox)
                },
                contentColor = Color.White,
                elevation = FloatingActionButtonDefaults.elevation(8.dp),
                shape = RoundedCornerShape(8.dp),
                modifier = Modifier
                    .absolutePadding(bottom = 20.dp)
                    .offset(y = (-20).dp)
            ) {
                Icon(
                    imageVector = Icons.Default.Create,
                    contentDescription = null,
                    tint = Color.White
                )
            }
        }
    ) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(it)
        ) {
            if (getRecipeUiState.showAddIngredientDialogueBox
                && !getRecipeUiState.isLoading
            ) {
                AddIngredientDialogueBoxScreen(
                    getRecipeUiState = getRecipeUiState,
                    onEvent = onEvent
                )
            }
            if (getRecipeUiState.showGetRecipeByNameDialogueBox &&
                !getRecipeUiState.isLoading
            ) {
                RecipeNameAlertBox(
                    updateRecipeName = { recipeName ->
                        onEvent(GetRecipeUiEvent.RecipeNameChange(recipeName))
                    },
                    height = 300,
                    onDismissRequest = {
                        onEvent(GetRecipeUiEvent.HideGetRecipeByNameDialogueBox)
                    },
                    getRecipeClick = {
                        onEvent(
                            GetRecipeUiEvent.GetRecipe(
                                showLoading = {
                                    getRecipeViewModel.uiEvent(GetRecipeUiEvent.HideGetRecipeByNameDialogueBox)
                                    getRecipeViewModel.uiEvent(GetRecipeUiEvent.ShowLoading)
                                },
                                addRecipe = takeRecipe,
                            )
                        )
                    },
                    recipeName = getRecipeUiState.recipeName
                )
            }
            if (getRecipeUiState.isLoading) {
                Column(
                    modifier = Modifier
                        .fillMaxSize(),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    CircularProgressIndicator()
                }
            } else{
                    LazyColumn(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(12.dp),
                        horizontalAlignment = Alignment.CenterHorizontally,
                    ) {
                        item {
                            PostRecipeDetailsEnterColumn(
                                getRecipeUiState = getRecipeUiState,
                                onEvent = onEvent
                            )
                            Spacer(modifier = Modifier.height(8.dp))
                            Button(
                                onClick = {
                                    onEvent(GetRecipeUiEvent.ShowAddIngredientDialogueBox)
                                },
                                shape = RoundedCornerShape(12.dp)
                            ) {
                                Text(
                                    text = "Add Ingredient",
                                    fontSize = 18.sp
                                )
                            }
                            Spacer(modifier = Modifier.height(40.dp))
                        }
                    }
                BottomRowButtons(
                    onEvent = getRecipeViewModel::uiEvent,
                    onCancelPostRecipe = onCancelPostRecipe,
                    takeRecipe = takeRecipe,
                    getRecipeViewModel = getRecipeViewModel
                )
            }
        }
    }
}


@Composable
fun RecipeNameAlertBox(
    updateRecipeName: (String) -> Unit,
    height: Int,
    onDismissRequest: () -> Unit,
    getRecipeClick: () -> Unit,
    recipeName: String
) {
    Box(
        modifier = Modifier
            .height(height.dp)
    ) {
        Dialog(onDismissRequest = onDismissRequest) {
            Column {
                TextField(value = recipeName,
                    onValueChange = updateRecipeName,
                    modifier = Modifier.fillMaxWidth(),

                    )
                Spacer(modifier = Modifier.height(12.dp))
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                ) {
                    OutlinedButton(onClick = onDismissRequest,
                        shape = RoundedCornerShape(12.dp),
                        modifier = Modifier
                            .weight(1F)
                            .height(56.dp)
                            .width(0.dp)
                    ) {
                        Text(
                            text = "Cancel",
                            fontSize = 16.sp,
                            color = Color.White
                        )
                    }
                    Spacer(modifier = Modifier.width(4.dp))
                    Button(
                        onClick = getRecipeClick,
                        shape = RoundedCornerShape(12.dp),
                        modifier = Modifier
                            .weight(1F)
                            .height(56.dp)
                            .width(0.dp)
                    ) {
                        Text(
                            text = "Get Recipe\uD83D\uDE0B",
                            fontSize = 16.sp
                        )
                    }
                }
            }
        }
    }
}


@Composable
fun AddIngredientDialogueBoxScreen(
    getRecipeUiState: GetRecipeUiState,
    onEvent: (GetRecipeUiEvent) -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        AddIngredientDialogueBox(
            onDismissRequest = {
                onEvent(GetRecipeUiEvent.CloseAddIngredientDialogueBox)
            },
            addIngredientClick = {
                onEvent(GetRecipeUiEvent.AddIngredient)
            },
            height = 300,
            ingredientName = getRecipeUiState.addIngredientDialogueBoxValue,
            updateIngredientName = {
                onEvent(GetRecipeUiEvent.AddIngredientDialogueBoxNameChange(it))
            }
        )
    }
}

@Composable
fun PostRecipeDetailsEnterColumn(
    getRecipeUiState: GetRecipeUiState,
    onEvent: (GetRecipeUiEvent) -> Unit
) {
    OutlinedTextField(
        value = getRecipeUiState.recipeDtoPost.title ?: "",
        onValueChange = {
            onEvent(GetRecipeUiEvent.RecipePostNameChange(it))
        },
        label = {
            Text(text = "Recipe Name")
        },
        modifier = Modifier
            .fillMaxWidth()
    )
    Spacer(modifier = Modifier.height(4.dp))
    Row(
        modifier = Modifier
            .fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceEvenly
    ) {
        OutlinedTextField(
            value = getRecipeUiState.recipeDtoPost.time ?: "",
            onValueChange = {
                onEvent(GetRecipeUiEvent.TimeChange(it))
            },
            label = {
                Text(text = "Time")
            },
            modifier = Modifier.weight(1F)
        )
        Spacer(modifier = Modifier.width(4.dp))
        OutlinedTextField(
            value = getRecipeUiState.recipeDtoPost.yield ?: "",
            onValueChange = {
                onEvent(GetRecipeUiEvent.YieldChange(it))
            },
            label = {
                Text(text = "Yield")
            },
            modifier = Modifier.weight(1F)
        )
    }
    Spacer(modifier = Modifier.height(4.dp))
    OutlinedTextField(
        value = getRecipeUiState.recipeDtoPost.summary ?: "",
        onValueChange = {
            onEvent(GetRecipeUiEvent.SummaryChange(it))
        },
        label = {
            Text(text = "Summary")
        },
        modifier = Modifier
            .fillMaxWidth()
    )
    Spacer(modifier = Modifier.height(4.dp))
    OutlinedTextField(
        value = getRecipeUiState.recipeDtoPost.prep ?: "",
        onValueChange = {
            onEvent(GetRecipeUiEvent.PrepChange(it))
        },
        label = {
            Text(text = "Preparation Steps")
        },
        modifier = Modifier
            .fillMaxWidth(),
    )
    getRecipeUiState.recipeDtoPost.ingredients.forEach { ingredient ->
        Spacer(modifier = Modifier.height(8.dp))
        IngredientItem(
            ingredientName = ingredient,
            onDeleteClick = {
                onEvent(GetRecipeUiEvent.DeleteIngredient(it))
            }
        )
    }
}


@Composable
fun BottomRowButtons(
    onEvent: (GetRecipeUiEvent) -> Unit,
    onCancelPostRecipe: () -> Unit,
    takeRecipe: (Recipe) -> Unit,
    getRecipeViewModel: GetRecipeViewModel
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 12.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Spacer(modifier = Modifier.weight(1F))
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .background(color = MaterialTheme.colorScheme.surface),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        ) {
            OutlinedButton(
                onClick = {
                    onEvent(GetRecipeUiEvent.ClearUiState)
                    onCancelPostRecipe()
                },
                modifier = Modifier
                    .weight(1F),
                shape = RoundedCornerShape(12.dp)
            ) {
                Text(
                    text = "Cancel",
                    fontSize = 16.sp
                )
            }
            Spacer(modifier = Modifier.width(4.dp))
            Button(
                onClick = {
                    onEvent(
                        GetRecipeUiEvent.PostRecipe(
                            showLoading = {
                                getRecipeViewModel.uiEvent(GetRecipeUiEvent.ShowLoading)
                            },
                            addRecipe = takeRecipe,
                        )
                    )
                },
                modifier = Modifier
                    .weight(1F),
                shape = RoundedCornerShape(12.dp)
            ) {
                Text(
                    text = "Get Nutrition",
                    fontSize = 16.sp
                )
            }
        }
    }
}