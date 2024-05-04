package com.sagar.nourishnow

import android.util.Log
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.sagar.nourishnow.common.Constants
import com.sagar.nourishnow.common.Resource
import com.sagar.nourishnow.data.repository.RecipeRemoteRepositoryImpl
import com.sagar.nourishnow.di.AppModule
import com.sagar.nourishnow.domain.remote.EdamamApi
import com.sagar.nourishnow.domain.remote.dto.RecipeDto
import com.sagar.nourishnow.domain.remote.dto.RecipeDtoPost
import com.squareup.moshi.JsonAdapter
import com.squareup.moshi.Moshi
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.dropWhile
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.test.runTest
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory


@ExperimentalCoroutinesApi
@RunWith(AndroidJUnit4::class)
class RecipeRemoteRepositoryTest {
    private lateinit var edamamApi: EdamamApi
    private lateinit var recipeRemoteRepository: RecipeRemoteRepositoryImpl
    private val moshi: Moshi = Moshi.Builder().build()
    private val jsonAdapter: JsonAdapter<RecipeDto> = moshi.adapter(RecipeDto::class.java)

    @Before
    fun setUp() {
        edamamApi = Retrofit
            .Builder()
            .baseUrl(Constants.baseUrl)
            .addConverterFactory(MoshiConverterFactory.create(AppModule.provideMoshi()))
            .build()
            .create(EdamamApi::class.java)
        recipeRemoteRepository = RecipeRemoteRepositoryImpl(edamamApi)
    }

    @Test
    fun singleIngredientTest() = runTest{
        val queryMap = mapOf(
            "app_id" to "764ac739",
            "app_key" to "8a441fd527278dd8472e08092b2ab396",
            "nutrition-type" to "cooking",
            "ingr" to "2 dosa"
        )
        val parsedRecipeDto = jsonAdapter.fromJson(Constants.dosaData)
        val recipeDtoResource = recipeRemoteRepository.getIngredientNutrition(queryMap)
            .dropWhile { it is Resource.Loading }
            .first()
        assert(recipeDtoResource is Resource.Success)
        assert(recipeDtoResource.data != null)
        assert(parsedRecipeDto == recipeDtoResource.data)
//        Log.d("TAG", recipeDtoResource.data.toString())
    }

    @Test
    fun postDataTest() = runTest {
        val queryMap = mapOf(
            "app_id" to "764ac739",
            "app_key" to "8a441fd527278dd8472e08092b2ab396"
        )
        val recipeDtoPost = RecipeDtoPost(
            title = "Delicious Pasta Carbonara",
            ingredients = listOf(
                "200g spaghetti",
                "100g pancetta",
                "2 cloves garlic",
                "2 large eggs",
                "50g Parmesan cheese",
                "Salt and pepper to taste"
            ),
            summary = "A classic Italian pasta dish made with pancetta, eggs, and Parmesan cheese.",
            yield = "Serves 2",
            time = "30 minutes",
            prep = "10 minutes"
        )
        val parsedPostData = jsonAdapter.fromJson(Constants.postData)
        val recipeDtoResource = recipeRemoteRepository.getRecipeNutrition(queryMap, recipeDtoPost)
            .dropWhile { it is Resource.Loading }
            .first()
        assert(recipeDtoResource is Resource.Success)
        assert(recipeDtoResource.data != null)
        assert(parsedPostData == recipeDtoResource.data)
    }

}