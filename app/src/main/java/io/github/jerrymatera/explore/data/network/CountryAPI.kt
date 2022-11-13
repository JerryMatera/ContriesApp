package io.github.jerrymatera.explore.data.network

import io.github.jerrymatera.explore.data.models.CountryDTO
import io.github.jerrymatera.explore.utils.Constants.BASE_URL
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Path

interface CountryAPI {

    @GET("all")
    suspend fun getCountries(): List<CountryDTO>

    @GET("name/{name}")
    suspend fun getCountryByName(
       @Path(value = "name") name: String
    ): CountryDTO

    companion object {

        fun create(): CountryAPI {

            val logger = HttpLoggingInterceptor().apply { level = HttpLoggingInterceptor.Level.BASIC }

            val client = OkHttpClient.Builder()
                .addInterceptor(logger)
                .build()

            return Retrofit.Builder()
                .baseUrl(BASE_URL)
                .client(client)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(CountryAPI::class.java)
        }
    }
}