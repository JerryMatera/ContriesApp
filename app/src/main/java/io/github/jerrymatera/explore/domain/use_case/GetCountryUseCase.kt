package io.github.jerrymatera.explore.domain.use_case

import io.github.jerrymatera.explore.data.models.CountryWithDetails
import io.github.jerrymatera.explore.domain.repository.CountryRepository
import io.github.jerrymatera.explore.utils.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class GetCountryUseCase @Inject constructor(
    private val repository: CountryRepository
) {
    operator fun invoke(name: String): Flow<Resource<CountryWithDetails>> = flow {
        try {
            emit(Resource.Loading<CountryWithDetails>())
            val country = repository.getCountryByName(name = name)
            emit(Resource.Success<CountryWithDetails>(country))
        } catch (e: HttpException) {
            emit(
                Resource.Error<CountryWithDetails>(
                    message = e.localizedMessage ?: "An expected error occurred"
                )
            )
        } catch (e: IOException) {
            emit(
                Resource.Error<CountryWithDetails>(
                    message = "Couldn't reach the server, Check your internet connect"
                )
            )
        }
    }
}