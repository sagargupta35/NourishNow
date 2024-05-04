package com.sagar.nourishnow.data.offline.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.sagar.nourishnow.domain.model.IngredientItem
import com.sagar.nourishnow.domain.model.MajorNutrient
import com.sagar.nourishnow.domain.model.Recipe
import java.time.LocalDate
import java.util.Date


@Entity(tableName = "RecipeOffline")
data class RecipeOffline(
    @PrimaryKey(autoGenerate = true)
    val recipeId: Long = 0,
    val date: LocalDate,
    val name: String,
    val fatKcal: Double,
    val proteinKcal: Double,
    val carbohydrateKcal: Double,
){
    fun toRecipe(
        ingredientItemList: List<IngredientItem>,
        majorNutrientList: List<MajorNutrient>,
        recipeId: Long
    ): Recipe {
        return Recipe(
            recipeId = recipeId,
            date = date,
            name =  name,
            fatKcal = fatKcal,
            proteinKcal = proteinKcal,
            carbohydrateKcal = carbohydrateKcal,
            ingredients = ingredientItemList,
            majorNutrients = majorNutrientList
        )
    }
}

