package com.sagar.nourishnow.di

import android.content.Context
import androidx.room.Room
import com.sagar.nourishnow.common.Constants
import com.sagar.nourishnow.data.offline.RecipeDatabase
import com.sagar.nourishnow.domain.remote.EdamamApi
import com.sagar.nourishnow.data.repository.RecipeRemoteRepositoryImpl
import com.sagar.nourishnow.data.offline.RecipeDao
import com.sagar.nourishnow.domain.repository.RecipeRemoteRepository
import com.squareup.moshi.Moshi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Singleton
    @Provides
    fun provideAppDatabase(@ApplicationContext context: Context): RecipeDatabase {
        return Room.databaseBuilder(
            context.applicationContext,
            RecipeDatabase::class.java,
            "recipe_database"
        )
        .fallbackToDestructiveMigration()
        .build()
    }

    @Singleton
    @Provides
    fun provideRecipeDao(@ApplicationContext context: Context): RecipeDao {
        return provideAppDatabase(context).recipeDao()
    }

    @Provides
    fun provideMoshi(): Moshi {
        return Moshi
            .Builder()
            .build()
    }

    @Provides
    @Singleton
    fun provideEdamamApi(): EdamamApi {
        return Retrofit
            .Builder()
            .baseUrl(Constants.baseUrl)
            .addConverterFactory(MoshiConverterFactory.create(provideMoshi()))
            .build()
            .create(EdamamApi::class.java)
    }

    @Provides
    @Singleton
    fun provideRecipeRepository(): RecipeRemoteRepository {
        return RecipeRemoteRepositoryImpl(provideEdamamApi())
    }

}