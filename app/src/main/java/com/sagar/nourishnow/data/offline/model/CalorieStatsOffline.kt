package com.sagar.nourishnow.data.offline.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.Date


@Entity(tableName = "CalorieStatsOffline")
data class CalorieStatsOffline(
    @PrimaryKey(autoGenerate = false)
    val date: Date,
    val calorieLimit: Int,
    val caloriesConsumed: Int,
    val caloriesBurned: Int,
)
