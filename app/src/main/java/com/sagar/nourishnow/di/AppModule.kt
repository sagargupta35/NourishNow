package com.sagar.nourishnow.di

import com.sagar.nourishnow.common.Constants
import com.sagar.nourishnow.domain.remote.EdamamApi
import com.sagar.nourishnow.data.repository.RecipeRepositoryImpl
import com.sagar.nourishnow.domain.repository.RecipeRepository
import com.squareup.moshi.Moshi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object AppModule {

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
    fun provideRecipeRepository(): RecipeRepository {
        return RecipeRepositoryImpl(provideEdamamApi())
    }

}