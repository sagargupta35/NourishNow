package com.sagar.nourishnow

import android.content.Context
import android.util.Log
import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import com.sagar.nourishnow.common.Constants
import com.sagar.nourishnow.data.offline.RecipeDatabase
import com.sagar.nourishnow.data.offline.model.CalorieStatsOffline
import com.sagar.nourishnow.data.offline.model.NutrientsKcalOffline
import com.sagar.nourishnow.data.repository.RecipeOfflineRepositoryImpl
import com.sagar.nourishnow.domain.remote.dto.RecipeDto
import com.sagar.nourishnow.domain.repository.RecipeOfflineRepository
import com.sagar.nourishnow.presentation.get_recipe.use_case.AddRecipeUseCase
import com.squareup.moshi.Moshi
import kotlinx.coroutines.test.runTest
import org.junit.Before
import org.junit.Test
import java.time.LocalDate


class AddRecipeUseCaseTest {

    private lateinit var addRecipeUseCase: AddRecipeUseCase
    private val moshi = Moshi.Builder().build()
    private val adapter = moshi.adapter<RecipeDto>(RecipeDto::class.java)
    private lateinit var recipeOfflineRepository: RecipeOfflineRepository

    @Before
    fun setUp(){
        val context = ApplicationProvider.getApplicationContext<Context>()
        val recipeDatabase = Room.inMemoryDatabaseBuilder(context, RecipeDatabase::class.java)
            .allowMainThreadQueries()
            .build()
        val recipeDao = recipeDatabase.recipeDao()
        recipeOfflineRepository = RecipeOfflineRepositoryImpl(recipeDao)
        addRecipeUseCase = AddRecipeUseCase(
            recipeOfflineRepository
        )

    }

    @Test
    fun testAddRecipeUseCase() = runTest {
        val recipeDto = adapter.fromJson(Constants.jsonData)
        val date = LocalDate.now()
        recipeOfflineRepository.addNutrientsKcal(
            NutrientsKcalOffline(
                date = date,
                carbohydrates = 0.0,
                fat = 0.0,
                energy = 0.0,
                protein = 0.0
            )
        )
        recipeOfflineRepository.addCalorieStats(
            CalorieStatsOffline(
                date = date,
                caloriesRemaining = 2000,
                caloriesConsumed = 0,
                calorieLimit = 2000
            )
        )
        addRecipeUseCase.addRecipe(
            recipeDto = recipeDto,
            recipeName = "TEST",
            date = LocalDate.now(),
            updateRecipe = {
            }
        )
    }


}