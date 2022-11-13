package io.github.jerrymatera.explore.presentation.home_screen

import io.github.jerrymatera.explore.domain.model.Country

data class CountriesListState(
    val isLoading: Boolean = false,
    val countries: List<Country> = emptyList(),
    val error: String = ""
)
