package com.sagar.nourishnow.domain.remote.dto

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass


@JsonClass(generateAdapter = true)
data class RecipeDtoPost(
    val title: String? = null,
    @Json(name = "ingr")
    val ingredients: List<String> = listOf(),
    val summary: String? = null,
    val yield: String? = null,
    val time: String? = null,
    val prep: String? = null,
    val image: String? = null
)