package com.sagar.nourishnow.domain.remote.dto

import com.squareup.moshi.JsonClass


@JsonClass(generateAdapter = true)
data class NutrientDto(
    val label: String?,
    val quantity: Double?,
    val unit: String?,
)
