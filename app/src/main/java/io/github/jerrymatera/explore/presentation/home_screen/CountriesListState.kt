package io.github.jerrymatera.explore.presentation.home_screen

import io.github.jerrymatera.explore.data.models.Country

data class CountriesListState(
    val isLoading: Boolean = false,
    val countries: List<Country> = emptyList(),
    val error: String = ""
)
