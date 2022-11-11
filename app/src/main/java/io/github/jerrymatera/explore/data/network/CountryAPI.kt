package io.github.jerrymatera.explore.data.network

import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import io.github.jerrymatera.explore.data.models.Country
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET
import retrofit2.http.Path

interface CountryAPI {

    @GET("/all")
    suspend fun getCountries(): List<Country>

    @GET("/name/{name}")
    suspend fun getCountry(
       @Path(value = "name") name: String
    ): Country

    companion object {
        private const val BASE_URL = "https://restcountries.com/v3.1"

        fun create(): CountryAPI {
            val moshi = Moshi.Builder()
                .add(KotlinJsonAdapterFactory())
                .build()

            val logger = HttpLoggingInterceptor().apply { level = HttpLoggingInterceptor.Level.BASIC }

            val client = OkHttpClient.Builder()
                .addInterceptor(logger)
                .build()

            return Retrofit.Builder()
                .baseUrl(BASE_URL)
                .client(client)
                .addConverterFactory(MoshiConverterFactory.create(moshi))
                .build()
                .create(CountryAPI::class.java)
        }
    }
}