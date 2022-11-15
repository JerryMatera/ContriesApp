package io.github.jerrymatera.explore.presentation.home_screen

sealed class HomeScreenEvent {
    data class onSearchQueryChange(val query: String) : HomeScreenEvent()
}
