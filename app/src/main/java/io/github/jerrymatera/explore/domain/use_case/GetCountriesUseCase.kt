package io.github.jerrymatera.explore.domain.use_case

import io.github.jerrymatera.explore.data.models.Country
import io.github.jerrymatera.explore.domain.repository.CountryRepository
import io.github.jerrymatera.explore.utils.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class GetCountriesUseCase @Inject constructor(
    private val repository: CountryRepository
) {
    operator fun invoke(): Flow<Resource<List<Country>>> = flow {
        try {
            emit(Resource.Loading<List<Country>>())
            val country = repository.getCountries()
            emit(Resource.Success<List<Country>>(country))
        } catch (e: HttpException) {
            emit(
                Resource.Error<List<Country>>(
                    message = e.localizedMessage ?: "An expected error occurred"
                )
            )
        } catch (e: IOException) {
            emit(
                Resource.Error<List<Country>>(
                    message = "Couldn't reach the server, Check your internet connect"
                )
            )
        }
    }
}