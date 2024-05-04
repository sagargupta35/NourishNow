package com.sagar.nourishnow.data.repository

import android.util.Log
import androidx.compose.ui.res.stringResource
import com.sagar.nourishnow.R
import com.sagar.nourishnow.common.Constants
import com.sagar.nourishnow.common.Constants.majorNutrientsMap
import com.sagar.nourishnow.common.Resource
import com.sagar.nourishnow.data.offline.model.CalorieStatsOffline
import com.sagar.nourishnow.data.offline.model.IngredientOffline
import com.sagar.nourishnow.data.offline.model.NutrientsKcalOffline
import com.sagar.nourishnow.data.offline.model.RecipeOffline
import com.sagar.nourishnow.domain.model.Ingredient
import com.sagar.nourishnow.domain.model.MajorNutrient
import com.sagar.nourishnow.domain.model.Nutrient
import com.sagar.nourishnow.data.offline.RecipeDao
import com.sagar.nourishnow.data.offline.model.IngredientItemOffline
import com.sagar.nourishnow.data.offline.model.MajorNutrientOffline
import com.sagar.nourishnow.data.offline.model.RecipeItemOffline
import com.sagar.nourishnow.domain.model.CalorieStats
import com.sagar.nourishnow.domain.model.IngredientItem
import com.sagar.nourishnow.domain.model.MeasuringUnit
import com.sagar.nourishnow.domain.model.NutrientsKcal
import com.sagar.nourishnow.domain.model.Recipe
import com.sagar.nourishnow.domain.model.RecipeItem
import com.sagar.nourishnow.domain.remote.dto.IngredientDto
import com.sagar.nourishnow.domain.remote.dto.NutrientDto
import com.sagar.nourishnow.domain.remote.dto.RecipeDto
import com.sagar.nourishnow.domain.repository.RecipeOfflineRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import java.time.LocalDate
import java.util.Date
import javax.inject.Inject

class RecipeOfflineRepositoryImpl @Inject constructor(
    private val recipeDao: RecipeDao
): RecipeOfflineRepository {

    private fun getNutrientInGrams(quantity: Double, unit: String): Double{
        val measuringUnit = MeasuringUnit.getUnit(unit)
        val conversionFactor = MeasuringUnit.convert(measuringUnit, MeasuringUnit.GRAMS).second
        return quantity * conversionFactor
    }

    /*
    * MajorNutrientMap is in Constants which specifies how the nutrients should be mapped into majorNutrients.
    * The map contains a majorName as key with a list of values that are the names of nutrients in Json Object
    * First it adds the majorNutrient with name as keyName and then with that majorNutrientId, it will add each nutrient into the database
    */

    private suspend fun addMajorNutrients(nutrients:Map<String, NutrientDto>, id: Long, isRecipeId: Boolean): List<MajorNutrient>{
        val majorNutrients = mutableListOf<MajorNutrient>()
        for((majorNutrientName, nutrientsList) in majorNutrientsMap){
            val majorNutrientOffline = MajorNutrientOffline(
                name = majorNutrientName,
                recipeId = if(isRecipeId) id else null,
                ingredientId = if(isRecipeId) null else id
            )
            val majorNutrientId = recipeDao.addMajorNutrient(majorNutrientOffline)
            val savedNutrientsList = mutableListOf<Nutrient>()
            for(nutrientName in nutrientsList){
                val nutrientDto = nutrients[nutrientName]
                if(nutrientDto != null){
                    val nutrientOffline = nutrientDto.toNutrientOffline(majorNutrientId)
                    recipeDao.addNutrient(nutrientOffline)
                    savedNutrientsList.add(nutrientOffline.toNutrient())
                }
            }
            val majorNutrient = majorNutrientOffline.toMajorNutrient(savedNutrientsList)
            majorNutrients.add(majorNutrient)
        }
        return majorNutrients
    }

    /*
    First save the recipe offline to get the recipeId ( 65-72)
    Save the ingredientOffline to get the ingredientId ( 74-91)
    With this ingredientId save the ingredientOfflineItem to get the IngredientItem. Then add the to ingredientItemList on 75
    */

    private suspend fun addIngredients(
        ingredients: List<IngredientDto>,
        recipeId: Long): List<IngredientItem>{
        val ingredientItemList = mutableListOf<IngredientItem>()
        ingredients.forEach { ingredientDto ->
            val lipidFatDto = ingredientDto.nutrientInformation?.get(0)?.nutrients?.get("FAPU")
            val carbsDto = ingredientDto.nutrientInformation?.get(0)?.nutrients?.get("CHOCDF")
            val proteinDto = ingredientDto.nutrientInformation?.get(0)?.nutrients?.get("PROCNT")

            val totalFat = getNutrientInGrams(
                lipidFatDto?.quantity ?: 0.0,
                lipidFatDto?.unit ?: "NULL_Unit"
            )
            val totalCarbs =
                getNutrientInGrams(carbsDto?.quantity ?: 0.0, carbsDto?.unit ?: "NULL_UNIT")
            val totalProtein =
                getNutrientInGrams(proteinDto?.quantity ?: 0.0, proteinDto?.unit ?: "NULL_UNIT")

            val ingredientOffline = IngredientOffline(
                name = ingredientDto.name ?: "Unknown",
                fatKcal = totalFat,
                carbohydrateKcal = totalCarbs,
                proteinKcal = totalProtein,
                recipeId = recipeId
            )
            val savedIngredientOfflineId = recipeDao.addIngredient(ingredientOffline)
            addMajorNutrients(
                ingredientDto.nutrientInformation?.get(0)?.nutrients ?: mapOf(),
                savedIngredientOfflineId,
                false
            )

            val ingredientItemOffline = IngredientItemOffline(
                recipeId = recipeId,
                ingredientId = savedIngredientOfflineId,
                name = ingredientDto.name ?: Constants.emptyValue
            )
            recipeDao.addIngredientItem(ingredientItemOffline)
            ingredientItemList.add(ingredientItemOffline.toIngredientItem())
        }
        return ingredientItemList
    }


    override suspend fun addRecipe(
        recipeDto: RecipeDto,
        date: LocalDate,
        name: String
    ) = flow {
            emit(Resource.Loading("Adding your Recipe\uD83E\uDD24")) //tasty emoji
            val recipeOffline = RecipeOffline(
                date = date,
                name = name,
                fatKcal = recipeDto.nutrientsKcal?.fat?.quantity ?: 0.0,
                carbohydrateKcal = recipeDto.nutrientsKcal?.carbohydrate?.quantity ?: 0.0,
                proteinKcal = recipeDto.nutrientsKcal?.protein?.quantity ?: 0.0
            )
            val savedRecipeOfflineId = recipeDao.addRecipe(recipeOffline)
            val majorNutrientList =
                addMajorNutrients(recipeDto.nutrients, savedRecipeOfflineId, true)

            val ingredientItemList =
                addIngredients(recipeDto.ingredients ?: listOf(), savedRecipeOfflineId)
            val savedRecipe =
                recipeOffline.toRecipe(ingredientItemList, majorNutrientList, savedRecipeOfflineId)

            val recipeItemOffline  = RecipeItemOffline(
                recipeId = savedRecipeOfflineId,
                name = name,
                date = date
            )

            recipeDao.addRecipeItemOffline(recipeItemOffline)
            emit(Resource.Success(savedRecipe))
    }.catch {
        emit(Resource.Error(it.localizedMessage ?: "Unknown error"))
    }

    override suspend fun deleteRecipe(recipeId: Long) = recipeDao.deleteRecipe(recipeId)

    private suspend fun getMajorNutrientByFoodId(foodId: Long, isRecipeId: Boolean): List<MajorNutrient> {
        val majorNutrients = mutableListOf<MajorNutrient>()
        val majorNutrientsOffline = if(isRecipeId) recipeDao.getMajorNutrientByRecipeId(foodId) else recipeDao.getMajorNutrientByIngredientId(foodId)
        majorNutrientsOffline.forEach { majorNutrientOffline ->
            val nutrientsOffline = recipeDao.getNutrientByMajorNutrientId(majorNutrientOffline.majorNutrientId)
            val nutrients = mutableListOf<Nutrient>()
            nutrientsOffline.forEach{nutrientOffline ->
                nutrients.add(nutrientOffline.toNutrient())
            }
            majorNutrients.add(majorNutrientOffline.toMajorNutrient(nutrients))
        }
        return majorNutrients
    }

    private suspend fun getIngredientItemsByRecipeId(recipeId: Long): List<IngredientItem>{
        val ingredientItemsOffline = recipeDao.getIngredientItemByRecipeId(recipeId)
        val ingredientItems = mutableListOf<IngredientItem>()
        ingredientItemsOffline.forEach { ingredientItemOffline ->
            ingredientItems.add(ingredientItemOffline.toIngredientItem())
        }
        return ingredientItems
    }

    override fun getIngredientById(ingredientId: Long): Flow<Resource<Ingredient>> = flow {
        emit(Resource.Loading())
        val majorNutrients = getMajorNutrientByFoodId(ingredientId, isRecipeId = false)
        val ingredientOffline = recipeDao.getIngredientById(ingredientId)
        emit(Resource.Success(ingredientOffline.toIngredient(majorNutrients)))
    }.catch {
        emit(Resource.Error(it.localizedMessage ?: "Unknown Error"))
    }

    override fun getRecipeById(recipeId: Long): Flow<Resource<Recipe>> = flow {
        emit(Resource.Loading())
        val majorNutrients = getMajorNutrientByFoodId(recipeId, true)
        val ingredientItems = getIngredientItemsByRecipeId(recipeId)
        val recipeOffline = recipeDao.getRecipeById(recipeId)
        emit(
            Resource.Success(
                recipeOffline.toRecipe(
                    ingredientItems,
                    majorNutrients,
                    recipeOffline.recipeId
                )
            )
        )
    }.catch {
        emit(Resource.Error(it.localizedMessage ?: "Unknown Error"))
    }

    override fun getCalorieStatsByDate(date: LocalDate): Flow<Resource<CalorieStatsOffline>> = flow {
        emit(Resource.Loading())
        val calorieStatsOffline = recipeDao.getCalorieStatsByDate(date)
        if(calorieStatsOffline != null) {
            emit(Resource.Success(calorieStatsOffline))
        } else{
            emit(Resource.Error("No items found for the given date"))
        }
    }.catch { e ->
        emit(Resource.Error(msg = e.localizedMessage?: "Stats do not exist for given date"))
    }

    override fun getNutrientKcalByDate(date: LocalDate): Flow<Resource<NutrientsKcalOffline>> = flow {
        emit(Resource.Loading())
        val nutrientsKcalOffline = recipeDao.getNutrientKcalByDate(date)
        if(nutrientsKcalOffline != null) {
            emit(Resource.Success(nutrientsKcalOffline))
        } else emit(Resource.Error("Not items found for the given date"))
    }.catch { e ->
        emit(Resource.Error(msg = e.localizedMessage?: "Stats do not exist for given date"))
    }

    override fun getRecipeItemsByDate(date: LocalDate): Flow<Resource<List<RecipeItem>>> = flow {
        emit(Resource.Loading())
        val recipeOfflineItems = recipeDao.getAllRecipeItems(date)
        emit(Resource.Success(recipeOfflineItems.map { it.toRecipeItem() }))
    }.catch {
        emit(Resource.Error(msg = it.localizedMessage ?: "Unknown Error fetching recipe items"))
    }

    override suspend fun updateNutrientsKcal(nutrientsKcal: NutrientsKcal) =
        recipeDao.updateNutrientKcal(nutrientsKcal.toNutrientsKcalOffline())

    override suspend fun updateCalorieStats(calorieStats: CalorieStats) =
        recipeDao.updateCalorieStats(calorieStats.toCalorieStatsOffline())

}
