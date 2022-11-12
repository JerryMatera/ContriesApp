package io.github.jerrymatera.explore.presentation.navigation

import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import io.github.jerrymatera.explore.presentation.ui.screens.DetailScreen
import io.github.jerrymatera.explore.presentation.home_screen.HomeScreen

@Composable
fun ExploreApp(modifier: Modifier = Modifier) {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = NavScreen.HomeScreen.name,
        modifier = modifier.padding(24.dp,16.dp)
    ) {
        composable(route = NavScreen.HomeScreen.name){
            HomeScreen()
        }
        composable(route = NavScreen.DetailScreen.name){
            DetailScreen()
        }
    }
}