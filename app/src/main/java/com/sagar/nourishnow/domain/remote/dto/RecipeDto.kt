package com.sagar.nourishnow.domain.remote.dto

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass


@JsonClass(generateAdapter = true)
data class RecipeDto(
    val calories: Double?,
    val totalWeight: Double?,
    @Json(name = "totalNutrients")
    val nutrients: Map<String, NutrientDto>,
    val ingredients: List<IngredientDto>?,
    @Json(name = "totalNutrientsKCal")
    val nutrientsKcal: NutrientsKcalDto?
)
