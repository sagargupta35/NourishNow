package com.sagar.nourishnow.data.remote.dto

import com.squareup.moshi.JsonClass


@JsonClass(generateAdapter = true)
data class NutrientDto(
    val label: String?,
    val quantity: Double?,
    val unit: String?,
)
