package com.sagar.nourishnow.data.offline

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.sagar.nourishnow.data.offline.converters.DateTypeConverter
import com.sagar.nourishnow.data.offline.converters.MeasuringUnitTypeConverter
import com.sagar.nourishnow.data.offline.model.CalorieStatsOffline
import com.sagar.nourishnow.data.offline.model.IngredientItemOffline
import com.sagar.nourishnow.data.offline.model.IngredientOffline
import com.sagar.nourishnow.data.offline.model.MajorNutrientOffline
import com.sagar.nourishnow.data.offline.model.NutrientOffline
import com.sagar.nourishnow.data.offline.model.NutrientsKcalOffline
import com.sagar.nourishnow.data.offline.model.RecipeItemOffline
import com.sagar.nourishnow.data.offline.model.RecipeOffline


@Database(entities = [CalorieStatsOffline::class, IngredientOffline::class,
    MajorNutrientOffline::class, NutrientOffline::class, RecipeOffline::class,
    NutrientsKcalOffline::class, IngredientItemOffline::class, RecipeItemOffline::class],
    version = 2,
    exportSchema = false)
@TypeConverters(DateTypeConverter::class, MeasuringUnitTypeConverter::class)
abstract class RecipeDatabase: RoomDatabase() {
    abstract fun recipeDao(): RecipeDao
}