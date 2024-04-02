package com.sagar.nourishnow.domain.remote

import com.sagar.nourishnow.domain.remote.dto.RecipeDto
import com.sagar.nourishnow.domain.remote.dto.RecipeDtoPost
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.POST
import retrofit2.http.QueryMap

interface EdamamApi {

    @GET("api/nutrition-data")
    suspend fun getIngredientNutrition(@QueryMap queryMap: Map<String, String>): RecipeDto


    @Headers(
        "accept: application/json",
        "Content-Type: application/json"
    )
    @POST("api/nutrition-details")
    suspend fun getRecipeNutrition(@Body recipe: RecipeDtoPost, @QueryMap queryMap: Map<String, String>): RecipeDto
}