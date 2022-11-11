package io.github.jerrymatera.explore.data.repository

import io.github.jerrymatera.explore.data.models.Country
import io.github.jerrymatera.explore.data.network.CountryAPI
import javax.inject.Inject

class CountryRepository @Inject constructor(private val countryAPI: CountryAPI)  {
    suspend fun getCountry(name: String): Country {
        return countryAPI.getCountry(name).body()!!
    }
}