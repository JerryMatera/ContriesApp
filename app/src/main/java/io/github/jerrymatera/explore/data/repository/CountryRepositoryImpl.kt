package io.github.jerrymatera.explore.data.repository

import io.github.jerrymatera.explore.data.models.CountryDTO
import io.github.jerrymatera.explore.data.network.CountryAPI
import io.github.jerrymatera.explore.domain.repository.CountryRepository
import javax.inject.Inject

class CountryRepositoryImpl @Inject constructor(
    private val api: CountryAPI
) : CountryRepository {
    override suspend fun getCountries(): List<CountryDTO> {
        return api.getCountries()
    }

    override suspend fun getCountryByName(name: String): CountryDTO {
        return api.getCountryByName(name)
    }
}