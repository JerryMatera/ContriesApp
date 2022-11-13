package io.github.jerrymatera.explore.presentation.country_detail_screen

import io.github.jerrymatera.explore.domain.model.CountryWithDetails

data class DetailScreenState(
    val isLoading: Boolean = false,
    val country: CountryWithDetails? = null,
    val error: String = ""
)
