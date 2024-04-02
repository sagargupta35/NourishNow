package com.sagar.nourishnow.data.offline.model

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey


/**
major nutrient table stores all the major nutrients from all recipes and ingredients
each major nutrient may belong to either as recipe or an ingredient so only one among the is non null
each major nutrient has a one to many relationship to th nutrient table
 */

@Entity(tableName = "MajorNutrientOffline",
    foreignKeys = [ForeignKey(
        entity = RecipeOffline::class,
        parentColumns = ["recipeId"],
        childColumns = ["recipeId"],
        onUpdate = ForeignKey.CASCADE,
        onDelete = ForeignKey.CASCADE
    ),
    ForeignKey(
        entity = IngredientOffline::class,
        parentColumns = ["ingredientId"],
        childColumns = ["ingredientId"],
        onUpdate = ForeignKey.CASCADE,
        onDelete = ForeignKey.CASCADE
    )]
)
data class MajorNutrientOffline(
    @PrimaryKey(autoGenerate = true)
    val majorNutrientId:Int = 1,
    val name: String,

    val recipeId: Int?,
    val ingredientId: Int?
)
