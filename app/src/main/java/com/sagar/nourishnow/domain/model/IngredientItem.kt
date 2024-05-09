package com.sagar.nourishnow.domain.model

import com.squareup.moshi.JsonClass


@JsonClass(generateAdapter = true)
data class IngredientItem(
    val recipeId: Long,
    val ingredientId: Long,
    val name: String,
)
