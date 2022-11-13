package io.github.jerrymatera.explore.domain.repository

import io.github.jerrymatera.explore.data.models.CountryDTO

interface CountryRepository {

    suspend fun getCountries(): List<CountryDTO>

    suspend fun getCountryByName(name: String): CountryDTO
}