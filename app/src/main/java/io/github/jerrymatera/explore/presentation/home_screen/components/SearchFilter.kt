package io.github.jerrymatera.explore.presentation.home_screen.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import io.github.jerrymatera.explore.R
import io.github.jerrymatera.explore.presentation.ui.theme.ExploreTheme
import io.github.jerrymatera.explore.presentation.ui.theme.Orange

@Composable
fun SearchFilter(
    onLanguageClick: ()->Unit,
    onFilterClick: ()->Unit,
) {
    Row(
        horizontalArrangement = Arrangement.SpaceBetween,
        modifier = Modifier
            .fillMaxWidth()
    ) {
        Button(
            onClick = onLanguageClick,
            colors = ButtonDefaults.outlinedButtonColors(
                contentColor = MaterialTheme.colors.onPrimary,
            ),
            modifier = Modifier
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
            onClick = onFilterClick,
            colors = ButtonDefaults.outlinedButtonColors(
                contentColor = MaterialTheme.colors.onPrimary,
            ),
            modifier = Modifier
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

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun SearchFilterPreview() {
    ExploreTheme {
        SearchFilter(onFilterClick = {}, onLanguageClick = {})
    }
}