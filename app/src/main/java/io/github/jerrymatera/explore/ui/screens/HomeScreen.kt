package io.github.jerrymatera.explore.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import io.github.jerrymatera.explore.R
import io.github.jerrymatera.explore.ui.theme.ExploreTheme

@Composable
fun HomeScreen(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier
            .fillMaxWidth()
    ) {
        TopBar()
        ListSection()
    }
}

@Composable
fun TopBar(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier
            .fillMaxWidth()
    ) {
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
        OutlinedTextField(
            value = "",
            onValueChange = {},
            leadingIcon = {
                Icon(
                    imageVector = Icons.Default.Search,
                    contentDescription = null
                )
            },
            placeholder = {
                Text(text = "Search Country")
            },
            modifier = modifier
                .fillMaxWidth()
                .heightIn(min = 56.dp)
                .padding(bottom = 8.dp)
        )
        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = modifier
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
}

@Composable
fun ListSection(modifier: Modifier = Modifier) {
    Text(text = "Lists goes here")
}

@Preview(showSystemUi = true, showBackground = true)
@Composable
fun HomeScreenPreview() {
    ExploreTheme {
        HomeScreen(
            modifier = Modifier
                .padding(24.dp)
                .fillMaxWidth()
        )
    }
}