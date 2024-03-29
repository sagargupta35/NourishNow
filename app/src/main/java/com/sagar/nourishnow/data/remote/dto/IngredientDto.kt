package com.sagar.nourishnow.data.remote.dto

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass


@JsonClass(generateAdapter = true)
data class IngredientDto(
    @Json(name = "text")
    val name: String?,
    @Json(name = "parsed")
    val nutrientInformation: List<NutrientInformation>?,

)
