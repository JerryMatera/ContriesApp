package io.github.jerrymatera.explore.presentation.navigation

sealed class NavScreen(val route: String) {
    object HomeScreen : NavScreen("home_screen")
    object DetailScreen : NavScreen("detail_screen")
}