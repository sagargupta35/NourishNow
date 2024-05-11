package com.sagar.nourishnow.presentation.common

import androidx.compose.foundation.layout.RowScope
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationDefaults
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.ContentAlpha
import androidx.compose.material.LocalContentColor
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Home
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState


sealed class Screen(
    val route: String,
    val title: String,
    val icon: ImageVector,
    val onClick: () -> Unit
){
    data class Home(
        val onButtonClick: () -> Unit
    ): Screen(
        Routes.HOME_SCREEN,
        "Home",
        Icons.Filled.Home,
        onButtonClick
    )

    data class PostRecipe(
        val onButtonClick: () -> Unit
    ): Screen(
        Routes.POST_RECIPE_SCREEN,
        "Add Recipe",
        Icons.Filled.Add,
        onButtonClick
    )
}


@Composable
fun MyBottomBar(
    navController: NavHostController,
    screens: List<Screen>
) {
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry?.destination?.route

    BottomNavigation(
        elevation = 20.dp
    ) {
        screens.forEach {screen ->
            AddItem(
                screen = screen,
                currentDestination = currentRoute,
                navController = navController
            )
        }
    }
    
}


@Composable
fun RowScope.AddItem(
    screen: Screen,
    currentDestination: String?,
    navController: NavHostController
) {

    BottomNavigationItem(
        label = {
            Text(text = screen.title)
        },
        icon = {
            Icon(
                imageVector = screen.icon,
                contentDescription = screen.title
            )
        },
        selected = currentDestination == screen.route,
        onClick = {
            screen.onClick()
            navController.navigate(screen.route){
                popUpTo(navController.graph.findStartDestination().id)
                launchSingleTop = true
            }
        },
        selectedContentColor = Color.White,
        unselectedContentColor = Color(0xFFAAAAAA)
    )

}