package com.sagar.nourishnow.domain.model

import com.sagar.nourishnow.data.offline.model.MajorNutrientOffline
import com.squareup.moshi.JsonClass

/*
@Param nutrients: they are the sub nutrients under each major nutrient
major nutrients are carbohydrates, fats, proteins, vitamins, fibre, microNutrients
 */

@JsonClass(generateAdapter = true)
data class MajorNutrient(
    val recipeId: Long?,
    val ingredientId: Long?,
    val name: String,
    val nutrients: List<Nutrient>
){
    fun toMajorNutrientOffline(): MajorNutrientOffline{
        return MajorNutrientOffline(
            name = name,
            recipeId = recipeId,
            ingredientId = ingredientId
        )
    }
}