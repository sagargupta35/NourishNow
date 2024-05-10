package com.sagar.nourishnow.domain.model

import com.squareup.moshi.JsonClass
import java.time.LocalDate


@JsonClass(generateAdapter = true)
data class RecipeItem(
    val name: String,
    val recipeId: Long,
    val date: LocalDate,
    val carbs: Int,
    val protein: Int,
    val fat: Int,
)