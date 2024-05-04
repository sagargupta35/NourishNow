package com.sagar.nourishnow.data.offline.model

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey
import com.sagar.nourishnow.domain.model.IngredientItem


@Entity(tableName = "IngredientItemOffline",
    foreignKeys = [
        ForeignKey(
            entity = IngredientOffline::class,
            childColumns = ["ingredientId"],
            parentColumns = ["ingredientId"],
            onDelete = ForeignKey.CASCADE,
            onUpdate = ForeignKey.CASCADE
        ),
        ForeignKey(
            entity = RecipeOffline::class,
            childColumns = ["recipeId"],
            parentColumns = ["recipeId"],
            onDelete = ForeignKey.CASCADE,
            onUpdate = ForeignKey.CASCADE
        )
    ]
)
data class IngredientItemOffline(
    @PrimaryKey(autoGenerate = true)
    val ingredientItemId: Long = 0,
    val recipeId: Long,
    val ingredientId: Long,
    val name: String
){
    fun toIngredientItem(): IngredientItem {
        return IngredientItem(
            recipeId = recipeId,
            ingredientId = ingredientId,
            name = name
        )
    }
}

