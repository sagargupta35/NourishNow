package com.sagar.nourishnow

import androidx.test.ext.junit.runners.AndroidJUnit4
import com.sagar.nourishnow.common.Constants.jsonData
import com.sagar.nourishnow.data.repository.RecipeOfflineRepositoryImpl
import com.sagar.nourishnow.domain.remote.dto.RecipeDto
import com.squareup.moshi.JsonAdapter
import com.squareup.moshi.Moshi
import org.junit.Test
import org.junit.runner.RunWith
import java.time.LocalDate
import java.util.Date
import javax.inject.Inject


class JsonParsingTest {
    val moshi: Moshi = Moshi.Builder().build()
    val jsonAdapter: JsonAdapter<RecipeDto> = moshi.adapter(RecipeDto::class.java)

    @Inject lateinit var recipeOfflineRepositoryImpl: RecipeOfflineRepositoryImpl

    @Test
    fun `checks the data classes`() {
        val recipeDto = jsonAdapter.fromJson(jsonData)
        assert(recipeDto != null)
    }
}
