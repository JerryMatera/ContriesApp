package io.github.jerrymatera.explore.presentation.home_screen.components

import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import io.github.jerrymatera.explore.data.models.Country

@Composable
fun Country(
    country: Country,
    modifier: Modifier = Modifier,
    ) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .padding(8.dp)
    ) {
        AsyncImage(
            model = country.flags.svg,
            contentDescription = null,
            modifier = modifier
                .size(40.dp)
        )
        Column(modifier = modifier) {
            Text(text = country.name.official)
            Text(text = country.capital.get(0))
        }
    }
}
