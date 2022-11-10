package io.github.jerrymatera.explore

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import io.github.jerrymatera.explore.ui.ExploreApp
import io.github.jerrymatera.explore.ui.theme.ExploreTheme

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
