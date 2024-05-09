package com.sagar.nourishnow.domain.model

import com.sagar.nourishnow.data.offline.model.NutrientOffline
import com.sagar.nourishnow.domain.model.MeasuringUnit
import com.squareup.moshi.JsonClass


@JsonClass(generateAdapter = true)
data class Nutrient(
    val quantity: Double,
    val  name: String,
    val unit: MeasuringUnit
){
    fun toNutrientOffline(majorNutrientId: Long): NutrientOffline {
        return NutrientOffline(
            quantity = quantity,
            name = name,
            unit = unit,
            majorNutrientId = majorNutrientId,
        )
    }
}

