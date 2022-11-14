package io.github.jerrymatera.explore.presentation.country_detail_screen

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import io.github.jerrymatera.explore.domain.use_case.GetCountryByNameUseCase
import io.github.jerrymatera.explore.utils.Constants
import io.github.jerrymatera.explore.utils.Resource
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class DetailScreenViewModel @Inject constructor(
    private val getCountryByNameUseCase: GetCountryByNameUseCase,
    savedStateHandle: SavedStateHandle
) : ViewModel() {
    private val _state = mutableStateOf(DetailScreenState())
    val state: State<DetailScreenState>
        get() = _state

    init {
        savedStateHandle.get<String>(Constants.PARAM_COUNTRY_NAME)?.let { name ->
            getCountryByName(name)
        }

    }

    private fun getCountryByName(name: String) {
        getCountryByNameUseCase(name = name).onEach { result ->
            when (result) {
                is Resource.Error -> {
                    _state.value = DetailScreenState(
                        error = result.message ?: "Error occurred",
                    )
                }
                is Resource.Loading -> {
                    _state.value = DetailScreenState(
                        isLoading = true,
                    )
                }
                is Resource.Success -> {
                    _state.value = DetailScreenState(
                        country = result.data!!
                    )
                }
            }
        }.launchIn(viewModelScope)

    }
}