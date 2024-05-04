package com.sagar.nourishnow.domain.model

import com.sagar.nourishnow.data.offline.model.NutrientsKcalOffline
import java.time.LocalDate

data class NutrientsKcal(
    val date: LocalDate,
    val carbohydrates: Double,
    val energy: Double,
    val fat: Double,
    val protein: Double
){
    fun toNutrientsKcalOffline(): NutrientsKcalOffline = NutrientsKcalOffline(
        date = date,
        carbohydrates = carbohydrates,
        energy = energy,
        fat = fat,
        protein = protein
    )
}