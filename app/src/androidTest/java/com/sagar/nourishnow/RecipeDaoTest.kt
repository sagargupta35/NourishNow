package com.sagar.nourishnow

import android.content.Context
import android.util.Log
import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.sagar.nourishnow.common.Constants
import com.sagar.nourishnow.common.Constants.jsonData
import com.sagar.nourishnow.common.Resource
import com.sagar.nourishnow.data.offline.RecipeDao
import com.sagar.nourishnow.data.offline.RecipeDatabase
import com.sagar.nourishnow.data.repository.RecipeOfflineRepositoryImpl
import com.sagar.nourishnow.domain.remote.dto.RecipeDto
import com.sagar.nourishnow.domain.repository.RecipeOfflineRepository
import com.squareup.moshi.JsonAdapter
import com.squareup.moshi.Moshi
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.drop
import kotlinx.coroutines.flow.dropWhile
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.takeWhile
import kotlinx.coroutines.test.TestScope
import kotlinx.coroutines.test.runTest
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import java.time.LocalDate
import java.util.Date


@ExperimentalCoroutinesApi
@RunWith(AndroidJUnit4::class)
class RecipeDaoTest {

    private lateinit var recipeDatabase: RecipeDatabase
    private lateinit var recipeDao: RecipeDao
    private lateinit var recipeOfflineRepository: RecipeOfflineRepository

    private val moshi: Moshi = Moshi.Builder().build()
    private val jsonAdapter: JsonAdapter<RecipeDto> = moshi.adapter(RecipeDto::class.java)

    @Before
    fun setUp(){
        val context = ApplicationProvider.getApplicationContext<Context>()
        recipeDatabase = Room.inMemoryDatabaseBuilder(context, RecipeDatabase::class.java)
            .allowMainThreadQueries()
            .build()
        recipeDao = recipeDatabase.recipeDao()
        recipeOfflineRepository = RecipeOfflineRepositoryImpl(recipeDao)
    }

    @After
    fun tearDown(){
        recipeDatabase.close()
    }

    @Test
    fun addRecipeTest() = runTest {
        val recipeDto = jsonAdapter.fromJson(jsonData)
        assert(recipeDto != null)
        assert(recipeDto?.nutrientsKcal != null)
        val resource = recipeOfflineRepository.addRecipe(recipeDto!!, LocalDate.now(), "test")
            .dropWhile { it is Resource.Loading }
            .first()
        assert(resource is Resource.Success)
    }

    @Test
    fun deleteRecipeTest() = runTest{
        val recipeDto = jsonAdapter.fromJson(jsonData)
        val resource = recipeOfflineRepository.addRecipe(recipeDto!!, LocalDate.now(), "test")
            .dropWhile { it is Resource.Loading }
            .first()
        assert(resource is Resource.Success)
        assert(resource.data != null)
        val id = resource.data!!.recipeId
        recipeOfflineRepository.deleteRecipe(resource.data!!.recipeId)
        val getRecipeResource = recipeOfflineRepository.getRecipeById(recipeId = id)
            .dropWhile { it is Resource.Loading }
            .first()
        assert(getRecipeResource is Resource.Error)
    }


    @Test
    fun getRecipeTest() = runTest{
        val recipeDto = jsonAdapter.fromJson(jsonData)
        val resource = recipeOfflineRepository.addRecipe(recipeDto!!, LocalDate.now(), "test")
            .dropWhile { it is Resource.Loading }
            .first()
        assert(resource is Resource.Success)
        assert(resource.data != null)
        val getRecipeResource = recipeOfflineRepository.getRecipeById(resource.data!!.recipeId)
            .dropWhile { it is Resource.Loading }
            .first()
        assert(getRecipeResource is Resource.Success)
    }

    @Test
    fun getIngredientTest() = runTest {
        val recipeDto = jsonAdapter.fromJson(jsonData)
        val resource = recipeOfflineRepository.addRecipe(recipeDto!!, LocalDate.now(), "test")
            .dropWhile { it is Resource.Loading }
            .first()
        assert(resource is Resource.Success)
        assert(resource.data != null)
        val getIngredientResource = recipeOfflineRepository.getIngredientById(resource.data!!.ingredients[0].ingredientId)
            .dropWhile { it is Resource.Loading }
            .first()
        assert(getIngredientResource is Resource.Success)
    }

    @Test
    fun getRecipeItemsByDate() = runTest{
        val recipeDto = jsonAdapter.fromJson(jsonData)
        val resource = recipeOfflineRepository.addRecipe(recipeDto!!, LocalDate.now(), "test")
            .dropWhile { it is Resource.Loading }
            .first()
        assert(resource is Resource.Success)
        assert(resource.data != null)
        val getRecipeResource = recipeOfflineRepository.getRecipeItemsByDate(LocalDate.now())
            .dropWhile { it is Resource.Loading }
            .first()
        assert(getRecipeResource is Resource.Success)
        Log.d("TAG", getRecipeResource.data.toString())
    }

}