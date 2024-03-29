package com.sagar.nourishnow.data.remote.dto

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass


@JsonClass(generateAdapter = true)
data class RecipeDto(
    val calories: Int?,
    @Json(name = "totalWeight")
    val totalWeight: Double?,
    @Json(name = "totalNutrients")
    val nutrients: Map<String, NutrientDto>,
    val ingredients: List<IngredientDto>?,
    val nutrientsKcal: NutrientsKcalDto?
)
