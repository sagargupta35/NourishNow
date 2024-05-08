package com.sagar.nourishnow.presentation.get_recipe

import android.widget.Toast
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.sagar.nourishnow.domain.remote.dto.RecipeDto
import com.sagar.nourishnow.domain.remote.dto.RecipeDtoPost
import com.sagar.nourishnow.presentation.get_recipe.common.AddIngredientDialogueBox
import com.sagar.nourishnow.presentation.get_recipe.common.GetRecipeUiEvent
import com.sagar.nourishnow.presentation.get_recipe.common.IngredientItem

@Preview(showBackground = true)
@Composable
fun PostRecipeScreen(
    getRecipeUiState: GetRecipeUiState = GetRecipeUiState(
        recipeDtoPost = RecipeDtoPost(
            ingredients = listOf(
                "100g vegetable rice",
                "200g biryani"
            )
        ),
    ),
    onEvent: (GetRecipeUiEvent) -> Unit = {},
    onCancelPostRecipe: () -> Unit = {},
    showLoading: () -> Unit = {},
    addRecipe: (RecipeDto?) -> Unit = {}
) {
    Box(modifier = Modifier.fillMaxSize()) {
        if(getRecipeUiState.showAddIngredientDialogueBox
            && !getRecipeUiState.isLoading
        ){
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
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(12.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            if(getRecipeUiState.isLoading){
                CircularProgressIndicator()
            } else{
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
                Spacer(modifier = Modifier.height(8.dp))
                Button(
                    onClick = {
                        onEvent(GetRecipeUiEvent.ShowAddIngredientDialogueBox)
                    },
                    shape = RoundedCornerShape(12.dp)
                ) {
                    Text(text = "Add Ingredient",
                        fontSize = 18.sp
                    )
                }
                Spacer(modifier = Modifier.weight(1F))
                Row(
                    modifier = Modifier
                        .fillMaxWidth(),
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
                        Text(text = "Cancel",
                            fontSize = 16.sp
                        )
                    }
                    Spacer(modifier = Modifier.width(4.dp))
                    Button(
                        onClick = {
                            onEvent(GetRecipeUiEvent.PostRecipe(
                                showLoading = showLoading,
                                addRecipe = addRecipe
                            ))
                        },
                        modifier = Modifier
                            .weight(1F),
                        shape = RoundedCornerShape(12.dp)
                    ) {
                        Text(text = "Get Nutrition",
                            fontSize = 16.sp
                        )
                    }
                }
            }
        }
    }
}