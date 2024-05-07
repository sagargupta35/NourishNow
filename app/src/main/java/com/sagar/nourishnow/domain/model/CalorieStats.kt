package com.sagar.nourishnow.domain.model

import androidx.room.PrimaryKey
import com.sagar.nourishnow.data.offline.model.CalorieStatsOffline
import java.time.LocalDate

data class CalorieStats(
    val date: LocalDate,
    val calorieLimit: Int,
    val caloriesConsumed: Int,
    val caloriesRemaining: Int
){
    fun toCalorieStatsOffline(): CalorieStatsOffline = CalorieStatsOffline(
        date = date,
        calorieLimit = calorieLimit,
        caloriesConsumed = caloriesConsumed,
        caloriesRemaining = caloriesRemaining
    )

}