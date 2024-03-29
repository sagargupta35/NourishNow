package com.sagar.nourishnow.data.offline.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.Date


@Entity(tableName = "CalorieStats")
data class CalorieStats(
    @PrimaryKey(autoGenerate = false)
    val date: Date,
    val calorieLimit: Int,
    val caloriesConsumed: Int,
    val caloriesBurned: Int,
)
