package com.sagar.nourishnow.domain.model

import com.sagar.nourishnow.data.offline.model.RecipeOffline
import java.time.LocalDate
import java.util.Date


/**
A recipe is a collection of ingredients
energy field can be obtained by adding all three params
 */


data class Recipe(
    val name: String,
    val fatKcal: Double,
    val proteinKcal: Double,
    val carbohydrateKcal: Double,
    val majorNutrients: List<MajorNutrient>,
    val ingredients: List<IngredientItem>,
    val date: LocalDate,
    val recipeId: Long,
    val yield: Int
){
    fun toRecipeOffline(): RecipeOffline{
        return RecipeOffline(
            name = name,
            fatKcal = fatKcal,
            proteinKcal = proteinKcal,
            carbohydrateKcal = carbohydrateKcal,
            date = date,
            yield = yield
        )
    }
}



