package com.sagar.nourishnow.data.remote.dto

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class NutrientInformation(
    val quantity: Double?,
    val measure: String?,
    @Json(name = "foodMatch")
    val food: String?,
    @Json(name = "retainedWeight")
    val weight: Double?,
    val nutrients: Map<String, NutrientDto>?
)
