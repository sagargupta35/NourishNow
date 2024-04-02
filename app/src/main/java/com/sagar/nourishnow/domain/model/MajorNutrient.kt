package com.sagar.nourishnow.domain.model

import com.sagar.nourishnow.data.offline.model.MajorNutrientOffline

/*
@Param nutrients: they are the sub nutrients under each major nutrient
major nutrients are carbohydrates, fats, proteins, vitamins, fibre, microNutrients
 */
data class MajorNutrient(
    val name: String,
    val nutrients: List<Nutrient>
){
    fun toMajorNutrientOffline(
        recipeId: Int?,
        ingredientId: Int?
    ): MajorNutrientOffline{
        return MajorNutrientOffline(
            name = name,
            recipeId = recipeId,
            ingredientId = ingredientId
        )
    }
}