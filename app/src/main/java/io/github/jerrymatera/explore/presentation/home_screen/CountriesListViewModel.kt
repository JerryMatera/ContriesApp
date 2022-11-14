package io.github.jerrymatera.explore.presentation.home_screen

import androidx.compose.runtime.State
import androidx.compose.runtime.getValue
import androidx.lifecycle.viewModelScope
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import io.github.jerrymatera.explore.domain.model.Country
import io.github.jerrymatera.explore.domain.use_case.GetCountriesUseCase
import io.github.jerrymatera.explore.utils.Resource
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class CountriesListViewModel @Inject constructor(
    private val getCountriesUseCase: GetCountriesUseCase
) : ViewModel() {
    private val _state = mutableStateOf(CountriesListState())
    val state: State<CountriesListState>
        get() = _state

    var searchText by mutableStateOf("")
        set


    init {
        getCountries()
    }

    private fun getCountries() {
        getCountriesUseCase().onEach { result ->
            when (result) {
                is Resource.Error -> {
                    _state.value = CountriesListState(
                        error = result.message ?: "Error occurred"
                    )
                }
                is Resource.Loading -> {
                    _state.value = CountriesListState(
                        isLoading = true
                    )
                }
                is Resource.Success -> {
                    _state.value = CountriesListState(
                        countries = result.data!!.sortedBy { it.name }
                    )
                }
            }
        }.launchIn(viewModelScope)

    }

    fun searchCountry(searchText: String): List<Country> {
        return  _state.value.countries.filter { it.name.contains(searchText) }
    }
}