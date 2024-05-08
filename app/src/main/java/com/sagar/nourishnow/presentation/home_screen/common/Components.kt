package com.sagar.nourishnow.presentation.home_screen.common

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
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
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


@Composable
fun AddRecipeDialogueBox(
    onDismissRequest: () -> Unit = {},
    onGetRecipeClick: () -> Unit = {},
    onPostRecipeClick:() -> Unit,
    height: Int = 300
) {
    Card(
        modifier = Modifier
            .height(height.dp),
        colors = CardDefaults.cardColors(MaterialTheme.colorScheme.onSurface)
    ) {
        Dialog(
            onDismissRequest = onDismissRequest
        ) {
            Column(
                modifier = Modifier
                    .padding(8.dp),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                AddRecipeButtonCard(
                    height = (height)/2,
                    onClick = onGetRecipeClick
                )
                Spacer(modifier = Modifier.height(8.dp))
                AddRecipeButtonCard(
                    cardColor = Color.Red,
                    buttonText = "Get Recipe",
                    height = (height)/2,
                    onPostRecipeClick
                )
            }
        }
    }
}


@Composable
fun AddRecipeButtonCard(
    cardColor: Color = Color.Green,
    buttonText: String = "Add Recipe",
    height: Int,
    onClick: () -> Unit,
) {
    Card(
        shape = RoundedCornerShape(8.dp),
        colors = CardDefaults.cardColors(cardColor)
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .height(height.dp)
                .clickable {
                     onClick()
                },
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Text(
                text = buttonText,
                fontSize = 20.sp
            )
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
                            fontSize = 16.sp
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