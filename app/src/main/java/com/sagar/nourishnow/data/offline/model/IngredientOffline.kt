package com.sagar.nourishnow.data.offline.model

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey
import com.sagar.nourishnow.domain.model.Ingredient
import com.sagar.nourishnow.domain.model.IngredientItem
import com.sagar.nourishnow.domain.model.MajorNutrient
import java.util.Date


@Entity(
    tableName = "IngredientOffline",
    foreignKeys = [
        ForeignKey(
        entity = RecipeOffline::class,
        parentColumns = ["recipeId"],
        onDelete = ForeignKey.CASCADE,
        onUpdate = ForeignKey.CASCADE,
        childColumns = ["recipeId"]
        )
    ]
)
data class IngredientOffline(
    @PrimaryKey(autoGenerate = true)
    val ingredientId: Long = 0,
    val name: String,
    val fatKcal: Double, // must be in grams
    val proteinKcal: Double, // must be in grams
    val carbohydrateKcal: Double, // must be in grams
    val recipeId: Long // the recipe it belongs to
){
    fun toIngredient(
        majorNutrients: List<MajorNutrient>
    ): Ingredient = Ingredient(
        name = name,
        fatKcal = fatKcal,
        proteinKcal = proteinKcal,
        carbohydrateKcal = carbohydrateKcal,
        recipeId = recipeId,
        ingredientId = ingredientId,
        majorNutrients = majorNutrients
    )

}
