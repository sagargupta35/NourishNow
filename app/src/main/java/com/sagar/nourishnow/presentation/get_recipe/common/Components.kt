package com.sagar.nourishnow.presentation.get_recipe.common

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog

@Preview
@Composable
fun IngredientItem(
    ingredientName: String = "100g Vegetable Rice",
    onDeleteClick: (String) -> Unit = {}
) {
    Card(
        colors = CardDefaults.cardColors(MaterialTheme.colorScheme.onSurface),
        shape = RoundedCornerShape(12.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 12.dp, vertical = 8.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = if(ingredientName.length > 30) {
                           ingredientName.take(30) + "..."
                       }
                       else {
                           ingredientName
                        },
                fontSize = 18.sp
            )
            Icon(
                imageVector = Icons.Default.Delete,
                contentDescription = "Delete ingredient",
                modifier = Modifier
                    .clickable { onDeleteClick(ingredientName)
                }
            )
        }
    }
}

@Composable
fun AddIngredientDialogueBox(
    updateIngredientName: (String) -> Unit,
    height: Int,
    onDismissRequest: () -> Unit,
    addIngredientClick: () -> Unit,
    ingredientName: String
) {
    Box(
        modifier = Modifier
            .height(height.dp)
            .fillMaxWidth()
    ) {
        Dialog(onDismissRequest = onDismissRequest) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
            ) {
                TextField(value = ingredientName,
                    onValueChange = updateIngredientName,
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
                            fontSize = 16.sp
                        )
                    }
                    Spacer(modifier = Modifier.width(4.dp))
                    Button(
                        onClick = addIngredientClick,
                        shape = RoundedCornerShape(12.dp),
                        modifier = Modifier
                            .weight(1F)
                            .height(56.dp)
                            .width(0.dp)
                    ) {
                        Text(
                            text = "Add Ingredient",
                            fontSize = 16.sp
                        )
                    }
                }
            }
        }
    }
}