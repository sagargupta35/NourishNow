package com.sagar.nourishnow.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.sagar.nourishnow.Navigation
import com.sagar.nourishnow.presentation.analytics.AnalyticsScreen
import com.sagar.nourishnow.presentation.home_screen.HomeScreenViewModel
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
                    Column(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(8.dp)
                    ) {
                        Navigation()
                    }
                }
            }
        }
    }
}
