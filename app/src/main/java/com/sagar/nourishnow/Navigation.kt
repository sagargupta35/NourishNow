package com.sagar.nourishnow

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.sagar.nourishnow.domain.model.Recipe
import com.sagar.nourishnow.domain.model.adapter.LocalDateAdapter
import com.sagar.nourishnow.presentation.common.MyBottomBar
import com.sagar.nourishnow.presentation.common.Routes
import com.sagar.nourishnow.presentation.common.Screen
import com.sagar.nourishnow.presentation.display_recipe.DisplayRecipeScreen
import com.sagar.nourishnow.presentation.get_recipe.PostRecipeScreen
import com.sagar.nourishnow.presentation.home_screen.HomeScreen
import com.sagar.nourishnow.presentation.home_screen.HomeScreenViewModel
import com.squareup.moshi.Moshi

@Composable
fun Navigation(
    navController: NavHostController = rememberNavController(),
    homeScreenViewModel: HomeScreenViewModel = hiltViewModel()
) {
    val moshi = Moshi
        .Builder()
        .add(LocalDateAdapter())
        .build()
    val jsonAdapter= moshi.adapter(Recipe::class.java)
    val screens = listOf(
        Screen.Home(
            onButtonClick = {

            }
        ),
        Screen.PostRecipe(
            onButtonClick = {

            }
        )
    )

    Scaffold(
        bottomBar = {
            MyBottomBar(
                navController = navController,
                screens = screens
            )
        }
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(it)
        ) {
            NavHost(navController = navController,
                startDestination = Routes.HOME_SCREEN
            ){
                composable(
                    route = Routes.HOME_SCREEN
                ){
                    HomeScreen(
                        viewModel = homeScreenViewModel
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
                            homeScreenViewModel.refreshScreen()
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
    }

}