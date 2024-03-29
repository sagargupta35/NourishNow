package com.sagar.nourishnow.data.remote.dto

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass


@JsonClass(generateAdapter = true)
data class NutrientsKcalDto(
    @Json(name = "ENERC_KCAL")
    val energy: NutrientDto?,
    @Json(name = "FAT_KCAL")
    val fat: NutrientDto?,
    @Json(name = "CHOCDF_KCAL")
    val carbohydrate: NutrientDto?,
    @Json(name = "PROCNT_KCAL")
    val protein: NutrientDto?,
)
