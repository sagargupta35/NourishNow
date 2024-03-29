package com.sagar.nourishnow

import com.sagar.nourishnow.common.Constants.jsonData
import com.sagar.nourishnow.data.remote.dto.RecipeDto
import com.squareup.moshi.JsonAdapter
import com.squareup.moshi.Moshi
import org.junit.Test

class JsonParsingTest {


    val moshi: Moshi = Moshi.Builder().build()
    val jsonAdapter: JsonAdapter<RecipeDto> = moshi.adapter(RecipeDto::class.java)

    @Test
    fun `checks the data classes`(){
        val recipeDto = jsonAdapter.fromJson(jsonData)
        assert(recipeDto != null)
    }

}
