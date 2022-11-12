package io.github.jerrymatera.explore.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import dagger.hilt.android.AndroidEntryPoint
import io.github.jerrymatera.explore.presentation.navigation.ExploreApp
import io.github.jerrymatera.explore.presentation.ui.theme.ExploreTheme

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ExploreTheme {
                Surface(color = MaterialTheme.colors.background) {
                    ExploreApp()
                }
            }
        }
    }
}
