package com.sagar.nourishnow

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.sagar.nourishnow.domain.model.Recipe
import com.sagar.nourishnow.domain.model.adapter.LocalDateAdapter
import com.sagar.nourishnow.domain.remote.dto.RecipeDto
import com.sagar.nourishnow.presentation.display_recipe.DisplayRecipeScreen
import com.sagar.nourishnow.presentation.get_recipe.PostRecipeScreen
import com.sagar.nourishnow.presentation.home_screen.HomeScreen
import com.squareup.moshi.Moshi

@Composable
fun Navigation(
    navController: NavHostController = rememberNavController()
) {
    val moshi = Moshi
        .Builder()
        .add(LocalDateAdapter())
        .build()
    val jsonAdapter= moshi.adapter(Recipe::class.java)
    NavHost(navController = navController,
        startDestination = Routes.HOME_SCREEN
    ){
        composable(
            route = Routes.HOME_SCREEN
        ){
            HomeScreen(
                onPostRecipeClick = {
                    navController.navigate(route = Routes.POST_RECIPE_SCREEN)
                }
            )
        }

        composable(route = Routes.POST_RECIPE_SCREEN){
            PostRecipeScreen(
                onCancelPostRecipe = {
                    navController.navigateUp()
                },
                takeRecipe = {
                    val recipeString = jsonAdapter.toJson(it)
                    val name = it.name
                    val calories = (it.carbohydrateKcal + it.fatKcal + it.proteinKcal).toInt()
                    val amountPerServing = it.yield
                    navController.navigate(
                        Routes.getDisplayRecipeScreenRoute(
                            name = name,
                            calories = calories,
                            amountPerServing = amountPerServing,
                            foodItem = recipeString,
                            isRecipe = true,
                            recipeId = it.recipeId
                        )
                    )
                }
            )
        }

        composable(
            route = Routes.DISPLAY_RECIPE_SCREEN,
            arguments = listOf(
                navArgument("name") { type = NavType.StringType },
                navArgument("recipeId") { type = NavType.StringType; nullable = true},
                navArgument("foodItem") { type = NavType.StringType },
                navArgument("calories") { type = NavType.IntType },
                navArgument("amountPerServing") { type = NavType.StringType; nullable = true },
                navArgument("isRecipe") { type = NavType.BoolType }
            )
        ){
            DisplayRecipeScreen(
                navigateOnError = {
                    navController.navigateUp()
                }
            )
        }
    }
}