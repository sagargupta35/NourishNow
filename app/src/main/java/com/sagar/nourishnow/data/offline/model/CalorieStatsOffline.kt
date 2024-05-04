package com.sagar.nourishnow.data.offline.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.sagar.nourishnow.domain.model.CalorieStats
import java.time.LocalDate
import java.util.Date


@Entity(tableName = "CalorieStatsOffline")
data class CalorieStatsOffline(
    @PrimaryKey(autoGenerate = false)
    val date: LocalDate,
    val calorieLimit: Int,
    val caloriesConsumed: Int,
){
    fun toCalorieStats(): CalorieStats = CalorieStats(
        date = date,
        calorieLimit = calorieLimit,
        caloriesConsumed = caloriesConsumed
    )
}
