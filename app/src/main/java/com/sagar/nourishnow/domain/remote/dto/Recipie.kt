package com.sagar.nourishnow.domain.remote.dto

import com.squareup.moshi.JsonClass


@JsonClass(generateAdapter = true)
data class Recipe(
    val title: String? = null,
    val ingredients: List<String>,
    val url: String? = null,
    val summary: String? = null,
    val yield: String? = null,
    val time: String? = null,
    val prep: String? = null,
    val image: String? = null
)