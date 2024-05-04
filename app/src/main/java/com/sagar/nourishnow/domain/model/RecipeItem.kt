package com.sagar.nourishnow.domain.model

import java.time.LocalDate

data class RecipeItem(
    val name: String,
    val recipeId: Long,
    val date: LocalDate
)