package com.sagar.nourishnow.data.offline.model

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.sagar.nourishnow.domain.model.RecipeDao
import com.sagar.nourishnow.data.offline.converters.DateTypeConverter
import com.sagar.nourishnow.data.offline.converters.MeasuringUnitTypeConverter


@Database(entities = [CalorieStatsOffline::class, IngredientOffline::class,
    MajorNutrientOffline::class, NutrientOffline::class, RecipeOffline::class,
    NutrientsKcalOffline::class],
    version = 1,
    exportSchema = false)
@TypeConverters(DateTypeConverter::class, MeasuringUnitTypeConverter::class)
abstract class RecipeDatabase: RoomDatabase() {
    abstract fun recipeDao(): RecipeDao
}