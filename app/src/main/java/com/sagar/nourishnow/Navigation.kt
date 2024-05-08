package com.sagar.nourishnow

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.sagar.nourishnow.presentation.get_recipe.PostRecipeScreen
import com.sagar.nourishnow.presentation.home_screen.HomeScreen

@Composable
fun Navigation(
    navController: NavHostController = rememberNavController()
) {
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
                addRecipe = {

                }
            )
        }
    }
}