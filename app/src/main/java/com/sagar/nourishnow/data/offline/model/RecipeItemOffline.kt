package com.sagar.nourishnow.data.offline.model

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey
import com.sagar.nourishnow.domain.model.RecipeItem
import java.time.LocalDate


@Entity(
    tableName = "RecipeItemOffline",
    foreignKeys = [
        ForeignKey(
            entity = RecipeOffline::class,
            parentColumns = ["recipeId"],
            childColumns = ["recipeId"],
            onDelete = ForeignKey.CASCADE
        )
    ]
)

data class RecipeItemOffline(
    val name: String,
    @PrimaryKey(autoGenerate = false)
    val recipeId: Long,
    val date: LocalDate
){
    fun toRecipeItem(): RecipeItem = RecipeItem(
        name = name,
        recipeId = recipeId,
        date = date
    )
}
