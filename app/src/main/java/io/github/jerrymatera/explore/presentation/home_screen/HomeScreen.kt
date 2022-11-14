package io.github.jerrymatera.explore.presentation.home_screen

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import io.github.jerrymatera.explore.presentation.home_screen.components.CountryItem
import io.github.jerrymatera.explore.presentation.home_screen.components.SearchBar
import io.github.jerrymatera.explore.presentation.home_screen.components.SearchFilter
import io.github.jerrymatera.explore.presentation.home_screen.components.TopBar
import io.github.jerrymatera.explore.presentation.navigation.NavScreen

@Composable
fun HomeScreen(
    navController: NavController,
    countriesListViewModel: CountriesListViewModel,
    modifier: Modifier = Modifier,

    ) {
    val state = countriesListViewModel.state.value
    val searchText = countriesListViewModel.searchText

    Column(
        modifier = modifier
            .fillMaxWidth()
            .padding(horizontal = 24.dp)
    ) {
        TopBar()
        SearchBar(
            searchText = searchText,
            onSearchTextChange = countriesListViewModel.searchCountry(searchText = searchText)
        )
        SearchFilter(
            onLanguageClick = {},
            onFilterClick = {}
        )
        Box(modifier = Modifier.fillMaxSize()) {
            LazyColumn(modifier = Modifier.fillMaxSize()) {
                items(state.countries) { country ->
                    CountryItem(
                        country = country,
                        onItemClick = {
                            navController.navigate(NavScreen.DetailScreen.route + "/${country.name}")
                        }
                    )
                }
            }
            if (state.error.isNotBlank()) {
                Text(
                    text = state.error,
                    color = MaterialTheme.colors.error,
                    textAlign = TextAlign.Center,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 20.dp)
                        .align(Alignment.Center)
                )
            }
            if (state.isLoading) {
                CircularProgressIndicator(modifier = Modifier.align(Alignment.Center))
            }
        }
    }
}