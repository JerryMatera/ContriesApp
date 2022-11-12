package io.github.jerrymatera.explore.presentation.home_screen.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import io.github.jerrymatera.explore.R

@Composable
fun TopBar(modifier: Modifier = Modifier) {
    Row(
        horizontalArrangement = Arrangement.SpaceBetween,
        modifier = modifier
            .fillMaxWidth()
            .padding(bottom = 8.dp)

    ) {
        Image(
            painter = painterResource(id = R.drawable.logo),
            contentDescription = null,
            modifier = modifier
                .height(32.dp)
        )
        Icon(
            painter = painterResource(id = R.drawable.light),
            contentDescription = null,
            modifier = modifier.size(24.dp)
        )

    }
}