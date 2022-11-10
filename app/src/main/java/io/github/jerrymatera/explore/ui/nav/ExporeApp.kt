package io.github.jerrymatera.explore.ui

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import io.github.jerrymatera.explore.ui.nav.NavScreen
import io.github.jerrymatera.explore.ui.screens.DetailScreen
import io.github.jerrymatera.explore.ui.screens.HomeScreen

@Composable
fun ExploreApp(modifier: Modifier = Modifier) {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = NavScreen.HomeScreen.name,
        modifier = modifier
    ) {
        composable(route = NavScreen.HomeScreen.name){
            HomeScreen()
        }
        composable(route = NavScreen.DetailScreen.name){
            DetailScreen()
        }
    }
}