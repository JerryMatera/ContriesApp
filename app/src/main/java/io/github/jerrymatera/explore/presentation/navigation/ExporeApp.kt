package io.github.jerrymatera.explore.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import io.github.jerrymatera.explore.presentation.home_screen.CountriesListViewModel
import io.github.jerrymatera.explore.presentation.country_detail_screen.DetailScreen
import io.github.jerrymatera.explore.presentation.country_detail_screen.DetailScreenViewModel
import io.github.jerrymatera.explore.presentation.home_screen.HomeScreen

@Composable
fun ExploreApp(modifier: Modifier = Modifier) {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = NavScreen.HomeScreen.route,
        modifier = modifier
    ) {
        composable(route = NavScreen.HomeScreen.route) {
            val viewModel = hiltViewModel<CountriesListViewModel>()
            HomeScreen(
                navController,
                viewModel
            )
        }
        composable(route = NavScreen.DetailScreen.route + "/{countryName}",
            arguments = listOf(navArgument("countryName"){
                type = NavType.StringType
            })
        )
        {
            val detailScreenViewModel = hiltViewModel<DetailScreenViewModel>()
            DetailScreen(
                navController,
                detailScreenViewModel
            )
        }
    }
}