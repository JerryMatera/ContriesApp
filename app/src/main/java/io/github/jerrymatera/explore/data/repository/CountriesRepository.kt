package io.github.jerrymatera.explore.data.repository

import io.github.jerrymatera.explore.data.models.Country
import io.github.jerrymatera.explore.data.network.CountryAPI
import javax.inject.Inject

class CountriesRepository @Inject constructor(private val countryAPI: CountryAPI) {
    suspend fun getCountries(): List<Country> {
        return countryAPI.getCountries().body()!!
    }
}