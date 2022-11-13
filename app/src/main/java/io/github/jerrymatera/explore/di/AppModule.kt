package io.github.jerrymatera.explore.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import io.github.jerrymatera.explore.data.network.CountryAPI
import io.github.jerrymatera.explore.data.repository.CountryRepositoryImpl
import io.github.jerrymatera.explore.domain.repository.CountryRepository
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {
    @Provides
    @Singleton
    fun provideCountryRepository(api: CountryAPI): CountryRepository {
        return CountryRepositoryImpl(api)
    }
}