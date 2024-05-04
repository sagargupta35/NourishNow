package com.sagar.nourishnow.domain.remote.dto

import com.sagar.nourishnow.common.Constants
import com.sagar.nourishnow.data.offline.model.NutrientOffline
import com.sagar.nourishnow.domain.model.MeasuringUnit
import com.sagar.nourishnow.domain.model.Nutrient
import com.squareup.moshi.JsonClass


@JsonClass(generateAdapter = true)
data class NutrientDto(
    val label: String?,
    val quantity: Double?,
    val unit: String?,
){
    fun toNutrient(): Nutrient {
        return Nutrient(
            quantity = quantity ?: 0.0,
            unit = MeasuringUnit.getUnit(unit),
            name = label ?: Constants.emptyValue
        )
    }

    fun toNutrientOffline(
        majorNutrientId: Long
    ): NutrientOffline = NutrientOffline(
        quantity = quantity?: 0.0,
        name = label?: Constants.emptyValue,
        unit = MeasuringUnit.getUnit(unit),
        majorNutrientId = majorNutrientId,
    )
}