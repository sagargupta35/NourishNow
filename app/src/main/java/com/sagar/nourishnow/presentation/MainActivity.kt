package com.sagar.nourishnow.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.TextField
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.hilt.navigation.compose.hiltViewModel
import com.sagar.nourishnow.Navigation
import com.sagar.nourishnow.presentation.display_recipe.DisplayRecipeScreen
import com.sagar.nourishnow.presentation.get_recipe.GetRecipeViewModel
import com.sagar.nourishnow.presentation.get_recipe.PostRecipeScreen
import com.sagar.nourishnow.presentation.home_screen.HomeScreen
import com.sagar.nourishnow.presentation.home_screen.common.HomeScreenUiEvent
import com.sagar.nourishnow.presentation.home_screen.HomeScreenViewModel
import com.sagar.nourishnow.presentation.home_screen.common.ProgressIndicatorBar
import com.sagar.nourishnow.ui.theme.NourishNowTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            NourishNowTheme {
                // A surface container using the 'background' color from the theme
                val viewModel = hiltViewModel<HomeScreenViewModel>()
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    var value by remember {
                        mutableIntStateOf(0)
                    }

                    Column(
                        verticalArrangement = Arrangement.Center,
                        horizontalAlignment = Alignment.CenterHorizontally,
                        modifier = Modifier.fillMaxSize()
                    ) {
                        ProgressIndicatorBar(
                            backgroundIndicatorColor = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.3f),
                            backgroundIndicatorStrokeWidth = 100f,
                            foreGroundIndicatorColor = MaterialTheme.colorScheme.primary,
                            foregroundIndicatorStrokeWidth = 100f,
                            amountFontSize = MaterialTheme.typography.headlineLarge.fontSize,
                            amountColor = MaterialTheme.colorScheme.onSurface,
                            percentageFontSize = MaterialTheme.typography.headlineSmall.fontSize,
                            percentageColor = MaterialTheme.colorScheme.onSurface,
                            showAmount = true,
                            indicatorValue = value
                        )
                        TextField(
                            value = value.toString(),
                            onValueChange = {
                                value = if(it.isNotBlank()){
                                    it.toInt()
                                } else 0
                            },
                            keyboardOptions = KeyboardOptions(
                                keyboardType = KeyboardType.Number
                            )
                        )
                    }


                }
            }
        }
    }
}
