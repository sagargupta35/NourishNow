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
import com.sagar.nourishnow.domain.model.IngredientItem
import com.sagar.nourishnow.domain.model.MajorNutrient
import com.sagar.nourishnow.presentation.display_recipe.common.IngredientItemCard
import com.sagar.nourishnow.presentation.display_recipe.common.RecipeNutritionCard


@Preview(showBackground = true)
@Composable
fun DisplayRecipeScreen(
    name: String = "Vegetable Rice",
    recipeId: Long? = null,
    onIngredientClick: (Long) -> Unit = {},
    majorNutrientList: List<MajorNutrient> = listOf(),
    calories: Int = 1773,
    ingredientItemList: List<IngredientItem>? = listOf(
        IngredientItem(
            ingredientId = 0,
            name = "Dal Rice 100g",
            recipeId = 0
        ),
        IngredientItem(
            ingredientId = 0,
            name = "Dal Rice 100g",
            recipeId = 0
        ),
        IngredientItem(
            ingredientId = 0,
            name = "Dal Rice 100g",
            recipeId = 0
        ),
        IngredientItem(
            ingredientId = 0,
            name = "Dal Rice 100g",
            recipeId = 0
        )
    ),
    amountPerServing: Int = 3,
    onDeleteClick: (Long) -> Unit = {},
    cancelDeleteClick: () -> Unit = {},
    displayRecipeUiState: DisplayRecipeUiState = DisplayRecipeUiState(),
    showDeleteDialogueBoxClick: () -> Unit = {}
) { 
    Box(modifier = Modifier.fillMaxSize()){
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            if(displayRecipeUiState.showDeleteRecipeDialogueBox &&
                !displayRecipeUiState.isLoading){
                DeleteRecipeDialogueBox(
                    onCancelClick = cancelDeleteClick,
                    onDeleteClick = onDeleteClick,
                    recipeId = recipeId ?: 0
                )
            }
        }
        LazyColumn(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 12.dp, horizontal = 16.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            item {
                if (displayRecipeUiState.isLoading) {
                    CircularProgressIndicator()
                } else {
                    Text(
                        text =
                        if(name.length > 30) name.take(30) + "..."
                        else name,
                        fontSize = 32.sp,
                        fontWeight = FontWeight.Bold
                    )
                    ingredientItemList?.forEach {
                        Spacer(modifier = Modifier.height(8.dp))
                        IngredientItemCard(
                            ingredientItem = it,
                            onClick = onIngredientClick
                        )
                    }
                    Spacer(modifier = Modifier.height(12.dp))
                    RecipeNutritionCard()
                    Spacer(modifier = Modifier.height(12.dp))
                }
                Button(onClick = showDeleteDialogueBoxClick,
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