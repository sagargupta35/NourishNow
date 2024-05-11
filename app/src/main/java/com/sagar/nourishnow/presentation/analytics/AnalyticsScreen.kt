package com.sagar.nourishnow.presentation.analytics



import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
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
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.lifecycle.viewmodel.compose.viewModel

@Composable
fun AnalyticsScreen(
    analyticsViewModel: AnalyticsViewModel = viewModel(),
    analyticsUiState: AnalyticsUiState = analyticsViewModel.analyticsUiState
) {
    val minCalories = analyticsUiState.analyticsData.minBy { it.energy }.energy
    val maxCalories = analyticsUiState.analyticsData.maxBy { it.energy }.energy

    val pointsData = getPointsData(
        analyticsUiState.analyticsData,
        maxCalories = maxCalories,
        minCalories = minCalories
    )

    val axisColor = Color(0xFFB0E0E6)
    val xAxisData = getXAxisData(
        pointsData.size-1,
            backgroundColor = axisColor
        )

    val yAxisData = getYAxisData(
        steps = 7,
        maxCalories = maxCalories,
        minCalories = minCalories,
        backgroundColor = axisColor
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

}


private fun getYAxisData(
    steps: Int,
    minCalories: Double,
    maxCalories: Double,
    backgroundColor: Color
): AxisData{
    return AxisData.Builder()
        .axisStepSize(15.dp)
        .steps(steps)
        .backgroundColor(backgroundColor)
        .labelAndAxisLinePadding(4.dp)
        .labelData {i ->
            (minCalories + i * ((maxCalories-minCalories)/(steps.toFloat()))).toInt().toString()
        }.build()
}


private fun getXAxisData(
    steps: Int,
    backgroundColor: Color
) : AxisData{
    return AxisData.Builder()
        .axisStepSize(100.dp)
        .steps(steps)
        .backgroundColor(backgroundColor)
        .labelData { i -> (i+1).toString() }
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

