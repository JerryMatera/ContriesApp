package io.github.jerrymatera.explore.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import io.github.jerrymatera.explore.presentation.home_screen.CountriesListViewModel
import io.github.jerrymatera.explore.presentation.ui.screens.DetailScreen
import io.github.jerrymatera.explore.presentation.home_screen.HomeScreen

@Composable
fun ExploreApp(modifier: Modifier = Modifier) {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = NavScreen.HomeScreen.name,
        modifier = modifier
    ) {
        composable(route = NavScreen.HomeScreen.name) {
            val viewModel = hiltViewModel<CountriesListViewModel>()
            HomeScreen(
                navController,
                viewModel
            )
        }
        composable(route = NavScreen.DetailScreen.name + "/{countryName}") {
            DetailScreen()
        }
    }
}