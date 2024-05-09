package com.sagar.nourishnow.presentation.home_screen.common

import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.animateIntAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
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
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.drawscope.DrawScope
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.TextUnit
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

@Composable
fun ProgressIndicatorBar(
    canvasSize: Dp = 300.dp,
    indicatorValue: Int = 0,
    maxIndicatorValue: Int = 100,
    backgroundIndicatorColor: Color,
    backgroundIndicatorStrokeWidth: Float,
    foreGroundIndicatorColor: Color,
    foregroundIndicatorStrokeWidth: Float,
    percentageFontSize: TextUnit,
    percentageColor: Color,
    amountFontSize: TextUnit,
    amountColor: Color,
    showAmount: Boolean
) {

    var allowedIndicatorValue by remember {
        mutableIntStateOf(maxIndicatorValue)
    }

    allowedIndicatorValue = if(indicatorValue <= maxIndicatorValue) indicatorValue else maxIndicatorValue

    var animatedIndicatorValue by remember {
        mutableFloatStateOf(0f)
    }
    LaunchedEffect(key1 = allowedIndicatorValue) {
        animatedIndicatorValue = allowedIndicatorValue.toFloat()
    }
    val percentage = (animatedIndicatorValue/maxIndicatorValue) * 100

    val sweepAngle by animateFloatAsState(
        targetValue = (3.6 * percentage).toFloat(),
        tween(1000),
        label = ""
    )

    val receivedValue by animateIntAsState(
        targetValue = indicatorValue,
        tween(1000),
        label = ""
    )

    Column(
        modifier = Modifier
            .size(canvasSize)
            .drawBehind {
                val componentSize = size / 1.25F
                backgroundIndicator(
                    componentSize,
                    backgroundIndicatorColor,
                    backgroundIndicatorStrokeWidth
                )
                foreGroundIndicator(
                    sweepAngle = sweepAngle,
                    componentSize = componentSize,
                    indicatorColor = foreGroundIndicatorColor,
                    indicatorStrokeWidth = foregroundIndicatorStrokeWidth
                )
            },
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        EmbeddedElements(
            percentage = percentage.toString(),
            amount = if(showAmount) receivedValue.toString() else null,
            percentageFontSize = percentageFontSize,
            percentageColor = percentageColor,
            amountFontSize = amountFontSize,
            amountColor = amountColor
        )

    }
    
}

@Composable
fun EmbeddedElements(
    percentage: String,
    amount: String?,
    percentageFontSize: TextUnit,
    percentageColor: Color,
    amountFontSize: TextUnit,
    amountColor: Color
) {
    Text(
        text = "${percentage.take(5)}%",
        color = percentageColor,
        fontSize = percentageFontSize
    )
    if(amount != null){
        Text(
            text = amount.take(6) + " kcal",
            fontSize = amountFontSize,
            color = amountColor,
            fontWeight = FontWeight.Bold
        )
    }
}

fun DrawScope.backgroundIndicator(
    componentSize: Size,
    indicatorColor: Color,
    indicatorStrokeWidth: Float
){
    drawArc(
        size = componentSize,
        color = indicatorColor,
        startAngle = 0f,
        sweepAngle = 360f,
        useCenter = false,
        style = Stroke(
            width = indicatorStrokeWidth,
            cap = StrokeCap.Round,
        ),
        topLeft = Offset(
            x = (size.width - componentSize.width)/2f,
            y = (size.height - componentSize.height)/2f
        )
    )
}

fun DrawScope.foreGroundIndicator(
    sweepAngle: Float,
    componentSize: Size,
    indicatorColor: Color,
    indicatorStrokeWidth: Float
){
    drawArc(
        size = componentSize,
        color = indicatorColor,
        startAngle = -90f,
        sweepAngle = -sweepAngle,
        useCenter = false,
        style = Stroke(
            width = indicatorStrokeWidth,
            cap = StrokeCap.Round,
        ),
        topLeft = Offset(
            x = (size.width - componentSize.width)/2f,
            y = (size.height - componentSize.height)/2f
        )
    )
}

@Preview(showBackground = true)
@Composable
fun ProgressBarIndicatorPreview() {
    ProgressIndicatorBar(
        backgroundIndicatorColor = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.3f),
        backgroundIndicatorStrokeWidth = 100f,
        foreGroundIndicatorColor = MaterialTheme.colorScheme.primary,
        foregroundIndicatorStrokeWidth = 100f,
        amountFontSize = MaterialTheme.typography.headlineLarge.fontSize,
        amountColor = MaterialTheme.colorScheme.onSurface,
        percentageFontSize = MaterialTheme.typography.headlineSmall.fontSize,
        percentageColor = MaterialTheme.colorScheme.onSurface,
        showAmount = true
    )

}