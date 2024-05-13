package com.sagar.nourishnow.presentation.analytics



import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import co.yml.charts.axis.AxisData
import co.yml.charts.common.model.Point
import co.yml.charts.ui.linechart.LineChart
import co.yml.charts.ui.linechart.model.GridLines
import co.yml.charts.ui.linechart.model.IntersectionPoint
import co.yml.charts.ui.linechart.model.Line
import co.yml.charts.ui.linechart.model.LineChartData
import co.yml.charts.ui.linechart.model.LinePlotData
import co.yml.charts.ui.linechart.model.LineStyle
import co.yml.charts.ui.linechart.model.SelectionHighlightPoint
import co.yml.charts.ui.linechart.model.SelectionHighlightPopUp
import co.yml.charts.ui.linechart.model.ShadowUnderLine
import com.sagar.nourishnow.domain.model.NutrientsKcal
import com.sagar.nourishnow.presentation.home_screen.common.ProgressIndicatorBar

@Composable
fun AnalyticsScreen(
    analyticsViewModel: AnalyticsViewModel = hiltViewModel(),
    analyticsUiState: AnalyticsUiState = analyticsViewModel.analyticsUiState
) {

    if(analyticsUiState.isLoading){
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            CircularProgressIndicator()
        }
    } else if(analyticsUiState.hasError){
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = analyticsUiState.errorMessage,
                fontSize = 20.sp
            )
        }
    } else {
        val minCalories = analyticsUiState.analyticsData.minBy { it.energy }.energy
        val maxCalories = analyticsUiState.analyticsData.maxBy { it.energy }.energy

        val pointsData = getPointsData(
            analyticsUiState.analyticsData,
            maxCalories = maxCalories,
            minCalories = minCalories
        )

        val axisColor = MaterialTheme.colorScheme.tertiaryContainer
        val xAxisData = getXAxisData(
            pointsData.size - 1,
            backgroundColor = axisColor,
            axisLabelColor = MaterialTheme.colorScheme.onTertiaryContainer
        )

        val yAxisData = getYAxisData(
            steps = 7.coerceAtMost(1.coerceAtLeast(pointsData.size - 1)),
            maxCalories = maxCalories,
            minCalories = minCalories,
            backgroundColor = axisColor,
            axisLabelColor = MaterialTheme.colorScheme.onTertiaryContainer
        )

        val lineChartData = LineChartData(
            linePlotData = LinePlotData(
                lines = listOf(
                    Line(
                        dataPoints = pointsData,
                        LineStyle(
                            color = MaterialTheme.colorScheme.onSurface
                        ),
                        IntersectionPoint(
                            color = MaterialTheme.colorScheme.onSurface
                        ),
                        SelectionHighlightPoint(
                            color = axisColor
                        ),
                        ShadowUnderLine(
                            color = Color(0xFF6CA6CD)
                        ),
                        SelectionHighlightPopUp(),
                    )
                ),
            ),
            xAxisData = xAxisData,
            yAxisData = yAxisData,
            backgroundColor = MaterialTheme.colorScheme.surface,
            gridLines = GridLines(
                color = MaterialTheme.colorScheme.onSurface
            )
        )


        val avgEnergy = analyticsUiState.analyticsData
            .map { it.energy }
            .average()
        val avgProtein = analyticsUiState.analyticsData
            .map { it.protein }
            .average()
        val avgFat = analyticsUiState.analyticsData
            .map { it.fat }
            .average()
        val avgCarbs = analyticsUiState.analyticsData
            .map { it.carbohydrates }
            .average()



        LazyColumn(
            modifier = Modifier
                .fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            item {
                Spacer(modifier = Modifier.height(8.dp))
                Card(
                    elevation = CardDefaults.cardElevation(4.dp)

                ) {
                    LineChart(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(300.dp),
                        lineChartData = lineChartData
                    )
                }
                Spacer(modifier = Modifier.height(12.dp))
                AverageNutrientInfo(
                    avgEnergy = avgEnergy.toInt(),
                    avgProtein = avgProtein.toInt(),
                    avgFat = avgFat.toInt(),
                    avgCarbs = avgCarbs.toInt(),
                )
            }
        }
    }
}

@Preview
@Composable
fun AverageNutrientInfo(
    avgEnergy: Int = 1680,
    avgProtein: Int = 865,
    avgFat: Int = 376,
    avgCarbs: Int = 280,
) {
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxWidth()
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceEvenly,
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp)
        ) {
            NutrientCard(
                name = "Energy",
                indicatorValue = avgEnergy,
                indicatorColor = Color.Cyan,
                maxIndicatorValue = 2000,
            )
            Spacer(modifier = Modifier.height(8.dp))
            NutrientCard(
                name = "Carbs",
                indicatorValue = avgCarbs,
                indicatorColor = Color.Magenta,
                maxIndicatorValue = 1250,
            )
        }
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceEvenly,
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp)
        ) {
            NutrientCard(
                name = "Fat",
                indicatorValue = avgFat,
                indicatorColor = Color.Green,
                maxIndicatorValue = 450,
            )
            Spacer(modifier = Modifier.height(8.dp))
            NutrientCard(
                name = "Protein",
                indicatorValue = avgProtein,
                indicatorColor = Color.Yellow,
                maxIndicatorValue = 350,
            )
        }
    }
}

@Preview
@Composable
fun NutrientCard(
    name: String = "Energy",
    indicatorColor: Color = Color.Cyan,
    indicatorValue: Int = 1789,
    maxIndicatorValue: Int = 2000,
    modifier: Modifier = Modifier
) {
    Card(
        elevation = CardDefaults.cardElevation(8.dp),
        colors = CardDefaults.cardColors(MaterialTheme.colorScheme.tertiary)
    ) {
        Column(
            modifier = modifier
                .padding(12.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = name,
                style = MaterialTheme.typography.titleLarge
            )
            Spacer(modifier = Modifier.height(8.dp))
            ProgressIndicatorBar(
                backgroundIndicatorStrokeWidth = 20f,
                foreGroundIndicatorColor = indicatorColor,
                foregroundIndicatorStrokeWidth = 30f,
                percentageFontSize = 20.sp,
                indicatorValue = indicatorValue,
                maxIndicatorValue = maxIndicatorValue,
                canvasSize = 130.dp,
                backgroundIndicatorColor = MaterialTheme.colorScheme.onTertiary
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = indicatorValue.toString(),
                style = MaterialTheme.typography.titleMedium
            )
        }
    }
}


private fun getYAxisData(
    steps: Int,
    minCalories: Double,
    maxCalories: Double,
    backgroundColor: Color,
    axisLabelColor: Color
): AxisData{
    return AxisData.Builder()
        .axisStepSize(15.dp)
        .steps(steps)
        .backgroundColor(backgroundColor)
        .axisLabelColor(axisLabelColor)
        .labelAndAxisLinePadding(4.dp)
        .labelData {i ->
            (minCalories + i * ((maxCalories-minCalories)/(steps.toFloat()))).toInt().toString()
        }.build()
}


private fun getXAxisData(
    steps: Int,
    backgroundColor: Color,
    axisLabelColor: Color
) : AxisData{
    return AxisData.Builder()
        .axisStepSize(100.dp)
        .steps(steps)
        .backgroundColor(backgroundColor)
        .labelData { i -> (i+1).toString() }
        .axisLabelColor(axisLabelColor)
        .labelAndAxisLinePadding(4.dp)
        .build()
}

private fun getPointsData(
    analyticsData: List<NutrientsKcal>,
    maxCalories: Double,
    minCalories: Double

): List<Point>{

    val points: MutableList<Point> = mutableListOf()
    val range = maxCalories - minCalories

    for(i in analyticsData.indices){
        points.add(
            Point(
                x = i.toFloat(),
                y = ((analyticsData[i].energy - minCalories)/(range)).toFloat()
            )
        )
    }

    return points
}

