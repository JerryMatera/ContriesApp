package io.github.jerrymatera.explore

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import io.github.jerrymatera.explore.presentation.navigation.ExploreApp
import io.github.jerrymatera.explore.presentation.ui.theme.ExploreTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ExploreTheme {
                ExploreApp()
            }
        }
    }
}
