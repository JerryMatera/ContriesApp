package io.github.jerrymatera.explore.presentation.home_screen

import androidx.compose.runtime.State
import androidx.lifecycle.viewModelScope
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import io.github.jerrymatera.explore.domain.model.Country
import io.github.jerrymatera.explore.domain.use_case.GetCountriesUseCase
import io.github.jerrymatera.explore.utils.Resource
import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CountriesListViewModel @Inject constructor(
    private val getCountriesUseCase: GetCountriesUseCase
) : ViewModel() {
    private val _state = mutableStateOf(CountriesListState())
    val state: State<CountriesListState>
        get() = _state

    private var searchJob: Job? = null

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

    fun onEvent(event: HomeScreenEvent){
        when(event){
            is HomeScreenEvent.onSearchQueryChange -> {
                _state.value = _state.value.copy(searchQuery = event.query)
                searchJob?.cancel()
                searchJob = viewModelScope.launch {
                    delay(500L)
                    searchCountry()
                }
            }
        }
    }
    private val filteredList = mutableListOf<Country>()


    private fun searchCountry(searchText: String = state.value.searchQuery) {
        viewModelScope.launch {
            val newCountryList: List<Country> =
                filteredList.filter { country ->
                    country.name.contains(searchText, ignoreCase = true)
                }


            _state.value = _state.value.copy(countries = newCountryList.sortedBy {
                it.name
            })
        }
    }
}