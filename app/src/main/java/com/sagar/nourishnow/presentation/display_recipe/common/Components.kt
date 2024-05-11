package com.sagar.nourishnow.presentation.display_recipe.common

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowRight
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
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
import com.sagar.nourishnow.domain.model.IngredientItem
import com.sagar.nourishnow.domain.model.MajorNutrient
import com.sagar.nourishnow.domain.model.MeasuringUnit
import com.sagar.nourishnow.domain.model.Nutrient
import java.text.DecimalFormat


@Composable
fun NutrientRow(
    quantity: Double = 1732.00,
    name: String = "MonoSaturated Fat",
    unit: MeasuringUnit = MeasuringUnit.getUnit("kg")
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
    ) {
        Spacer(modifier = Modifier.width(40.dp))
        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(
                text = getNutrientName(name),
                fontSize = 16.sp,
                fontWeight = FontWeight.Medium,
                color = Color.Black
            )
            Text(
                text = "${DecimalFormat("#.##").format(quantity)} ${unit.symbol}",
                fontWeight = FontWeight.Bold,
                fontSize = 16.sp,
                color = Color.Black
            )
        }
    }
}


@Composable
fun MajorNutrientColumn(
    majorNutrient: MajorNutrient = MajorNutrient(
        recipeId = null,
        ingredientId = null,
        name = "Carbohydrates",
        nutrients = listOf(

            Nutrient(
                name = "Carbohydrates",
                quantity = 453.00,
                unit = MeasuringUnit.getUnit("kcal")
            ),
            Nutrient(
                name = "Vitamin C",
                quantity = 234.00,
                unit = MeasuringUnit.getUnit("µg")
            ),
            Nutrient(
                name = "MonoSaturated Fat",
                quantity = 1732.00,
                unit = MeasuringUnit.getUnit("kcal")
            ),
            Nutrient(
                name = "Fibre",
                quantity = 178.00,
                unit = MeasuringUnit.getUnit("g")
            ),
        )
    )
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(12.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Card(
            shape = RoundedCornerShape(4.dp),
            colors = CardDefaults.cardColors(Color(0xFFEDEDED))
        ) {
            Row(
                horizontalArrangement = Arrangement.Start,
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.fillMaxWidth()
            ) {
                Spacer(modifier = Modifier.width(10.dp))
                Text(text = majorNutrient.name,
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.Black
                )
            }
        }
        Spacer(modifier = Modifier.height(8.dp))
        majorNutrient.nutrients.forEach {
            Spacer(modifier = Modifier.height(4.dp))
            Row {
                Spacer(modifier = Modifier.width(38.dp))
                Divider(
                    color = Color.LightGray,
                    thickness = 1.dp
                )
            }
            Spacer(modifier = Modifier.height(8.dp))
            NutrientRow(
                quantity = it.quantity,
                name = it.name,
                unit = it.unit
            )

        }
        Spacer(modifier = Modifier.height(6.dp))
        Divider(
            color = Color.LightGray,
            thickness = 1.dp
        )
    }
}


@Composable
fun RecipeNutritionCard(
    amountPerServing: String?,
    calories: Int,
    majorNutrients: List<MajorNutrient>
) {
    Card(
        shape = RoundedCornerShape(20.dp),
        colors = CardDefaults.cardColors(Color.White),
        elevation = CardDefaults.cardElevation(12.dp)
    ) {
        Column(
            modifier = Modifier
                .padding(vertical = 16.dp,
                    horizontal = 12.dp
                )
        ) {
            Spacer(modifier = Modifier.height(40.dp))
            Column {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.Center,
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Text(
                        text = "Nutrition Facts",
                        fontSize = 40.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color.Black
                    )
                }
                Spacer(modifier = Modifier.height(12.dp))
                Divider(
                    color = Color.LightGray,
                    thickness = 12.dp
                )
                Spacer(
                    modifier = Modifier.height(12.dp)
                )
                if (amountPerServing != null){
                    Row(
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically,
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        Text(
                            text = "Amount Per Serving",
                            fontWeight = FontWeight.Bold,
                            fontSize = 20.sp,
                            color = Color.Black
                        )
                        Text(
                            text = amountPerServing,
                            fontWeight = FontWeight.Bold,
                            fontSize = 20.sp,
                            color = Color.Black
                        )
                    }
                }
                Row(
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Text(
                        text = "Calories",
                        fontWeight = FontWeight.Bold,
                        fontSize = 40.sp,
                        color = Color.Black
                    )
                    Text(
                        text = "$calories",
                        fontWeight = FontWeight.Bold,
                        fontSize = 40.sp,
                        color = Color.Black
                    )
                }
                Spacer(
                    modifier = Modifier.height(12.dp)
                )
                Divider(
                    color = Color.LightGray,
                    thickness = 8.dp
                )
                Spacer(modifier = Modifier.height(8.dp))
                majorNutrients.forEach {
                    if(it.nutrients.isNotEmpty()) {
                        MajorNutrientColumn(majorNutrient = it)
                    }
                }
            }
            Spacer(modifier = Modifier.height(40.dp))
        }
    }
}


@Preview(showBackground = true)
@Composable
fun IngredientItemCard(
    onClick: (Long) -> Unit = {},
    ingredientItem: IngredientItem = IngredientItem(
        recipeId = 0,
        ingredientId = 1,
        name = "Ingredient 1",
    )
) {
    Card(
        colors = CardDefaults.cardColors(Color(0xFFDDDDDD)),
        shape = RoundedCornerShape(12.dp),
        modifier = Modifier
            .clickable { onClick(ingredientItem.ingredientId) }
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(
                    horizontal = 16.dp,
                    vertical = 8.dp
                ),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(
                text = ingredientItem.name,
                fontSize = 16.sp,
                color = Color.Black
            )
            Icon(
                imageVector = Icons.Default.KeyboardArrowRight,
                contentDescription = "Navigate to ingredient description screen",
                tint = Color.Black
            )
        }
    }
}

fun getNutrientName(
    name: String
): String{
    return when(name){
        "Carbohydrate, by difference" -> "Carbs (by difference)"
        "Fatty acids, total saturated" -> "Saturated Fats"
        "Fatty acids, total trans" -> "Trans Fat"
        "Fatty acids, total monounsaturated" -> "Monounsaturated Fat"
        "Fatty acids, total polyunsaturated" -> "Polyunsaturated Fat"
        "Vitamin C, total ascorbic acid" -> "Vitamin C"
        "Vitamin E (alpha-tocopherol)" -> "Vitamin E"
        "Vitamin K (phylloquinone)" -> "Vitamin K"
        "Sugars, total including NLEA" -> "Total Sugar"
        else -> {
            name
        }
    }
}


