package com.sagar.nourishnow.presentation.home_screen.common

import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.KeyboardArrowRight
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
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
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.sagar.nourishnow.domain.model.CalorieStats
import com.sagar.nourishnow.domain.model.NutrientsKcal
import com.sagar.nourishnow.domain.model.RecipeItem
import java.time.LocalDate


private data class NutrientInfo(
    val fat: Int,
    val carbs: Int,
    val protein: Int
)

@Composable
fun CalorieStatsCard(
    calorieStats: CalorieStats
) {
    Card(
        elevation = CardDefaults.cardElevation(8.dp),
        colors = CardDefaults.cardColors(MaterialTheme.colorScheme.tertiary)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        ) {
            Column(
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                NutrientText(
                    name = "Limit",
                    quantity = calorieStats.calorieLimit,
                    color = MaterialTheme.colorScheme.onTertiary,
                    headLineStyle = MaterialTheme.typography.titleLarge,
                    bodyLineStyle = MaterialTheme.typography.titleMedium
                )
                Spacer(modifier = Modifier.height(6.dp))
                NutrientText(
                    name = "Taken",
                    quantity = calorieStats.caloriesConsumed,
                    color = MaterialTheme.colorScheme.onTertiary,
                    headLineStyle = MaterialTheme.typography.titleLarge,
                    bodyLineStyle = MaterialTheme.typography.titleMedium
                )
                Spacer(modifier = Modifier.height(6.dp))
                NutrientText(
                    name = "Left",
                    quantity = calorieStats.caloriesRemaining,
                    color = MaterialTheme.colorScheme.onTertiary,
                    headLineStyle = MaterialTheme.typography.titleLarge,
                    bodyLineStyle = MaterialTheme.typography.titleMedium
                )
            }
            Spacer(modifier = Modifier.width(4.dp))
            ProgressIndicatorBar(
                backgroundIndicatorStrokeWidth = 20f,
                foreGroundIndicatorColor = Color.Magenta,
                foregroundIndicatorStrokeWidth = 30f,
                percentageFontSize = 20.sp,
                indicatorValue = calorieStats.caloriesConsumed,
                maxIndicatorValue = calorieStats.calorieLimit,
                canvasSize = 140.dp,
                backgroundIndicatorColor = MaterialTheme.colorScheme.onTertiary
            )
        }
    }
}


@Composable
fun NutrientsKcalCard(
    nutrientsKcal: NutrientsKcal
) {
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxWidth()
    ) {
        ProteinFatRow(
            proteinKcal = nutrientsKcal.protein.toInt(),
            fatKcal = nutrientsKcal.fat.toInt()
        )
        Spacer(modifier = Modifier.height(12.dp))
        CarbohydrateCard(
            name = "Carbs",
            indicatorValue = nutrientsKcal.carbohydrates.toInt(),
            maxIndicatorValue = 1250,
            foreGroundIndicatorColor = Color.Green,
            nutrientInfo = NutrientInfo(
                carbs = nutrientsKcal.carbohydrates.toInt(),
                fat = nutrientsKcal.fat.toInt(),
                protein = nutrientsKcal.protein.toInt()
            )
        )
    }
}

@Preview
@Composable
private fun CarbohydrateCard(
    name: String = "Carbs",
    indicatorValue: Int = 560,
    maxIndicatorValue: Int = 1250,
    foreGroundIndicatorColor: Color = Color.Green,
    nutrientInfo: NutrientInfo = NutrientInfo(
        fat = 340,
        protein = 210,
        carbs = 560
    ),
) {
    Card(
        colors = CardDefaults.cardColors(MaterialTheme.colorScheme.tertiary)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(12.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            Column(
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.Start,
                ) {
                    Text(
                        text = name,
                        style = MaterialTheme.typography.headlineSmall,
                        color = MaterialTheme.colorScheme.onTertiary
                    )
                }
                Spacer(modifier = Modifier.height(8.dp))
                ProgressIndicatorBar(
                    backgroundIndicatorStrokeWidth = 20f,
                    foreGroundIndicatorColor = foreGroundIndicatorColor,
                    foregroundIndicatorStrokeWidth = 30f,
                    percentageFontSize = 20.sp,
                    indicatorValue = indicatorValue,
                    maxIndicatorValue = maxIndicatorValue,
                    canvasSize = 130.dp,
                    backgroundIndicatorColor = MaterialTheme.colorScheme.onTertiary
                )
                Spacer(modifier = Modifier.height(8.dp))
            }
            Spacer(modifier = Modifier.width(4.dp))
            Column(
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                NutrientText(
                    name = "Carbs",
                    quantity = nutrientInfo.carbs,
                    color = MaterialTheme.colorScheme.onTertiary,
                    headLineStyle = MaterialTheme.typography.titleLarge,
                    bodyLineStyle = MaterialTheme.typography.titleMedium
                )
                Spacer(modifier = Modifier.height(4.dp))
                NutrientText(
                    name = "Protein",
                    quantity = nutrientInfo.protein,
                    color = MaterialTheme.colorScheme.onTertiary,
                    headLineStyle = MaterialTheme.typography.titleLarge,
                    bodyLineStyle = MaterialTheme.typography.titleMedium
                )
                Spacer(modifier = Modifier.height(4.dp))
                NutrientText(
                    name = "Carbs",
                    quantity = nutrientInfo.fat,
                    color = MaterialTheme.colorScheme.onTertiary,
                    headLineStyle = MaterialTheme.typography.titleLarge,
                    bodyLineStyle = MaterialTheme.typography.titleMedium
                )
            }
        }
    }
}

@Preview
@Composable
fun ProteinFatRow(
    proteinKcal: Int = 80,
    fatKcal: Int = 210,
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(210.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceEvenly
    ) {
        MajorNutrientKcal(
            modifier = Modifier
                .weight(1F),
            name = "Protein",
            indicatorValue = proteinKcal,
            maxIndicatorValue = 350,
            foreGroundIndicatorColor = Color.Yellow,
        )
        Spacer(modifier = Modifier.width(12.dp))
        MajorNutrientKcal(
            modifier = Modifier
                .weight(1F),
            name = "Fat",
            indicatorValue = fatKcal,
            maxIndicatorValue = 450,
            foreGroundIndicatorColor = Color.Cyan,
        )
    }
}


@Composable
private fun MajorNutrientKcal(
    modifier: Modifier = Modifier,
    name: String = "Carbs",
    indicatorValue: Int,
    maxIndicatorValue: Int,
    foreGroundIndicatorColor: Color = Color.Green,
) {
    Card(
        elevation = CardDefaults.cardElevation(8.dp),
        modifier = modifier,
        colors = CardDefaults.cardColors(MaterialTheme.colorScheme.tertiary)
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceEvenly,
            modifier = modifier
        ) {
            Column(
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = modifier
                    .fillMaxWidth()
                    .padding(8.dp)
            ) {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.Start,
                ) {
                    Text(
                        text = name,
                        style = MaterialTheme.typography.headlineSmall,
                        color = MaterialTheme.colorScheme.onTertiary
                    )
                }
                Spacer(modifier = Modifier.height(8.dp))
                ProgressIndicatorBar(
                    backgroundIndicatorStrokeWidth = 20f,
                    foreGroundIndicatorColor = foreGroundIndicatorColor,
                    foregroundIndicatorStrokeWidth = 30f,
                    percentageFontSize = 20.sp,
                    indicatorValue = indicatorValue,
                    maxIndicatorValue = maxIndicatorValue,
                    canvasSize = 130.dp,
                    backgroundIndicatorColor = MaterialTheme.colorScheme.onTertiary
                )
                Spacer(modifier = Modifier.height(8.dp))
            }
        }
    }
}

@Composable
fun NutrientText(
    name: String,
    quantity: Int,
    headingSize: Int = 20,
    valueSize: Int = 18,
    color: Color = Color.Black,
    headLineStyle: TextStyle = MaterialTheme.typography.titleLarge,
    bodyLineStyle: TextStyle = MaterialTheme.typography.titleMedium
) {
    Row(
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = "$name: ",
            color = color,
            style = headLineStyle
        )
        Text(
            text = "$quantity kcal",
            color = color,
            style = bodyLineStyle
        )
    }
}


@Composable
fun RecipeItemCard(
    recipeItem: RecipeItem = RecipeItem(
        name = "Vegetable Rice",
        recipeId = 0L,
        date = LocalDate.now(),
        carbs = 56,
        protein = 68,
        fat = 25
    ),
    onClick: (Long) -> Unit
) {
    val totalCalories = recipeItem.carbs + recipeItem.fat + recipeItem.protein
    Card(
        elevation = CardDefaults.cardElevation(8.dp),
        modifier = Modifier
            .clickable {
                onClick(recipeItem.recipeId)
            },
        colors = CardDefaults.cardColors(MaterialTheme.colorScheme.tertiaryContainer)
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp)
        ) {
            RecipeNameRow(
                name = recipeItem.name,
                calories = totalCalories
            )
            Spacer(modifier = Modifier.height(8.dp))
            NutrientRow(
                carbs = recipeItem.carbs,
                protein = recipeItem.protein,
                fat = recipeItem.fat
            )
        }
    }
}


@Composable
fun NutrientRow(
    carbs: Int = 56,
    protein: Int = 68,
    fat: Int = 25
) {
    val maxIndicatorValue = carbs+protein+fat
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceEvenly,
        modifier = Modifier.fillMaxWidth()
    ) {
        NutrientBar(
            name = "Carbs",
            indicatorValue = carbs,
            maxIndicatorValue = maxIndicatorValue,
            foreGroundIndicatorColor = Color.Green
        )
        NutrientBar(
            name = "Protein",
            indicatorValue = protein,
            maxIndicatorValue = maxIndicatorValue,
            foreGroundIndicatorColor = Color.Magenta
        )
        NutrientBar(
            name = "Fat",
            indicatorValue = fat,
            maxIndicatorValue = maxIndicatorValue,
            foreGroundIndicatorColor = Color.Yellow
        )
    }

}


@Composable
fun NutrientBar(
    name: String = "Carbs",
    indicatorValue: Int = 56,
    maxIndicatorValue: Int = 100,
    foreGroundIndicatorColor: Color = Color.Green
) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center
    ) {
        ProgressIndicatorBar(
            canvasSize = 60.dp,
            indicatorValue = indicatorValue,
            maxIndicatorValue = maxIndicatorValue,
            backgroundIndicatorColor = MaterialTheme.colorScheme.onTertiaryContainer,
            backgroundIndicatorStrokeWidth = 20f,
            foreGroundIndicatorColor = foreGroundIndicatorColor,
            foregroundIndicatorStrokeWidth = 20f,
            percentageFontSize = 12.sp,
        )
        Spacer(modifier = Modifier.width(4.dp))
        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = name,
                style = MaterialTheme.typography.labelSmall
            )
            Text(
                text = "$indicatorValue",
                style = MaterialTheme.typography.labelSmall
            )
            Text(
                text = "kcal",
                style = MaterialTheme.typography.labelSmall
            )
        }
    }
}


@Composable
fun RecipeNameRow(
    name: String = "Vegetable Rice",
    calories: Int = 320
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(4.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Column(
            horizontalAlignment = Alignment.Start,
            verticalArrangement = Arrangement.Center,
            modifier = Modifier.weight(8f)
        ) {
            Text(
                text = name,
                style = MaterialTheme.typography.headlineSmall
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = "\uD83D\uDD25$calories kcal",
                style = MaterialTheme.typography.titleMedium
            )
        }
        Icon(
            imageVector = Icons.AutoMirrored.Filled.KeyboardArrowRight,
            contentDescription = "Recipe Info",
            Modifier
                .size(30.dp)
                .weight(2f),
        )
    }
}


@Composable
fun ProgressIndicatorBar(
    canvasSize: Dp = 300.dp,
    indicatorValue: Int = 0,
    maxIndicatorValue: Int = 100,
    backgroundIndicatorColor: Color = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.3f),
    backgroundIndicatorStrokeWidth: Float,
    foreGroundIndicatorColor: Color,
    foregroundIndicatorStrokeWidth: Float,
    percentageFontSize: TextUnit
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
            percentage = percentage.toInt().toString(),
            percentageFontSize = percentageFontSize
        )

    }
    
}

@Composable
fun EmbeddedElements(
    percentage: String,
    percentageFontSize: TextUnit
) {
    Text(
        text = "${percentage.take(5)}%",
        fontSize = percentageFontSize
    )
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


@Composable
fun ProgressBarIndicatorPreview() {
    ProgressIndicatorBar(
        backgroundIndicatorColor = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.3f),
        backgroundIndicatorStrokeWidth = 100f,
        foreGroundIndicatorColor = MaterialTheme.colorScheme.primary,
        foregroundIndicatorStrokeWidth = 100f,
        percentageFontSize = MaterialTheme.typography.headlineSmall.fontSize,
    )
}