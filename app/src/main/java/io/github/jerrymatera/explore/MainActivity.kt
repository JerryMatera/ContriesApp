package io.github.jerrymatera.explore

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import io.github.jerrymatera.explore.ui.theme.ExploreTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ExploreTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    Explore()
                }
            }
        }
    }
}

@Composable
fun Explore() {
    Text(text = "Hello ")
}

@Preview(showSystemUi = true, showBackground = true)
@Composable
fun DefaultPreview() {
    ExploreTheme {
        Explore()
    }
}