package com.sagar.nourishnow.data.offline.model

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey
import com.sagar.nourishnow.domain.model.NutrientsKcal
import java.time.LocalDate
import java.util.Date

// this class is used to store the food consumed by the user in the past days

@Entity(tableName = "NutrientsKcalOffline")
data class NutrientsKcalOffline (
    @PrimaryKey(autoGenerate = false)
    val date: LocalDate,
    val carbohydrates: Double,
    val energy: Double,
    val fat: Double,
    val protein: Double
){
    fun toNutrientsKcal(): NutrientsKcal = NutrientsKcal(
        date = date,
        carbohydrates = carbohydrates,
        energy = energy,
        fat = fat,
        protein = protein
    )

}