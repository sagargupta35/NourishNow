package com.sagar.nourishnow.data.offline.model

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey
import com.sagar.nourishnow.domain.model.MeasuringUnit
import com.sagar.nourishnow.domain.model.Nutrient


/**
nutrient table stores all the sub nutrients of each major nutrients from all recipes
each nutrient will have the foreign key of the major nutrient it belongs to
 */

@Entity(tableName = "NutrientOffline",
    foreignKeys = [ForeignKey(
        entity = MajorNutrientOffline::class,
        parentColumns = ["majorNutrientId"],
        childColumns = ["majorNutrientId"],
        onDelete = ForeignKey.CASCADE,
        onUpdate = ForeignKey.CASCADE)
])
data class NutrientOffline(
    @PrimaryKey(autoGenerate = true)
    val nutrientId: Int = 1,
    val name: String,
    val quantity: Double,
    val unit: MeasuringUnit,
    val majorNutrientId: Int,
){
    fun toNutrient(): Nutrient {
        return Nutrient(
            quantity = quantity ?: 0.0,
            unit = unit,
            name = name
        )
    }
}
