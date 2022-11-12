package io.github.jerrymatera.explore.domain.repository

import io.github.jerrymatera.explore.data.models.Country
import io.github.jerrymatera.explore.data.models.CountryWithDetails

interface CountryRepository {

    suspend fun getCountries(): List<Country>

    suspend fun getCountryByName(name: String): CountryWithDetails
}