package com.sagar.nourishnow.data.offline.model

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey
import java.util.Date


@Entity(tableName = "NutrientsKcalOffline",
    foreignKeys = [ForeignKey(
        entity = CalorieStatsOffline::class,
        parentColumns = ["date"],
        childColumns = ["date"],
        onUpdate = ForeignKey.CASCADE,
        onDelete = ForeignKey.CASCADE
    )])
data class NutrientsKcalOffline (
    @PrimaryKey(autoGenerate = false)
    val date: Date,
    val carbohydrates: Double,
    val energy: Double,
    val fat: Double,
    val protein: Double
)