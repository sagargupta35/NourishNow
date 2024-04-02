package com.sagar.nourishnow.data.offline.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.Date


@Entity(tableName = "RecipeOffline")
data class RecipeOffline(
    @PrimaryKey(autoGenerate = true)
    val recipeId: Int = 1,
    val date: Date,
    val name: String,
    val fatKcal: Double,
    val proteinKcal: Double,
    val carbohydrateKcal: Double,
)

