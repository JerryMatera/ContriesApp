package io.github.jerrymatera.explore.presentation.home_screen.components

import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import io.github.jerrymatera.explore.R

@Composable
fun SearchFilter() {
    Row(
        horizontalArrangement = Arrangement.SpaceBetween,
        modifier = Modifier
            .fillMaxWidth()
    ) {
        Button(
            onClick = { /* ... */ },
            contentPadding = PaddingValues(12.dp),
            colors = ButtonDefaults.outlinedButtonColors()
        ) {
            Icon(
                painterResource(id = R.drawable.internet),
                contentDescription = null,
                modifier = Modifier.size(ButtonDefaults.IconSize)
            )
            Spacer(Modifier.size(ButtonDefaults.IconSpacing))
            Text("EN")
        }
        Button(
            onClick = { /* ... */ },
            contentPadding = PaddingValues(12.dp),
            colors = ButtonDefaults.outlinedButtonColors()
        ) {
            Icon(
                painterResource(id = R.drawable.outline_filter),
                contentDescription = null,
                modifier = Modifier.size(ButtonDefaults.IconSize)
            )
            Spacer(Modifier.size(ButtonDefaults.IconSpacing))
            Text(text = "filter")
        }

    }
}