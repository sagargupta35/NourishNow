package com.sagar.nourishnow.data.offline.model

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey
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
    val ingredientId: Int = 1,
    val name: String,
    val fatKcal: Double,
    val proteinKcal: Double,
    val carbohydrateKcal: Double,
    val recipeId: Int? // the recipe it belongs to
)
