package com.sagar.nourishnow.domain.model

import com.sagar.nourishnow.data.offline.model.IngredientOffline
import java.util.Date


/**
 * an ingredient will have no sub ingredients. each ingredient may belong to a specific recipe
 *
 */


data class Ingredient(
    val ingredientId: Long,
    val name: String,
    val fatKcal: Double,
    val proteinKcal: Double,
    val carbohydrateKcal: Double,
    val majorNutrients: List<MajorNutrient>,
    val recipeId: Long
){
    fun toIngredientOffline(): IngredientOffline {
        return IngredientOffline(
            name = name,
            fatKcal = fatKcal,
            proteinKcal = proteinKcal,
            carbohydrateKcal = carbohydrateKcal,
            recipeId = recipeId,
        )
    }
}
