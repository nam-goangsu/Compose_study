package com.namgs.autosize

import android.content.res.Configuration
import android.content.res.Configuration.*
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.tooling.preview.Preview
import com.namgs.autosize.ui.theme.AutosizeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            AutosizeTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Greeting(
                        name = "Android",
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    val configuration = LocalConfiguration.current
    val isPortrait =configuration.orientation === Configuration.ORIENTATION_PORTRAIT
    val screenLayoutSize =
        when (configuration.screenLayout and
                Configuration.SCREENLAYOUT_SIZE_MASK) {
            SCREENLAYOUT_SIZE_SMALL -> "SCREENLAYOUT_SIZE_SMALL"
            SCREENLAYOUT_SIZE_NORMAL -> "SCREENLAYOUT_SIZE_NORMAL"
            SCREENLAYOUT_SIZE_LARGE -> "SCREENLAYOUT_SIZE_LARGE"
            SCREENLAYOUT_SIZE_XLARGE -> "SCREENLAYOUT_SIZE_XLARGE"
            else -> "undefined value"
        }
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.fillMaxWidth()
    ) {
        Text("screenWidthDp: ${configuration.screenWidthDp}")
        Text("screenHeightDp: ${configuration.screenHeightDp}")
        Text("smallestScreenWidthDp: ${configuration.smallestScreenWidthDp}")
        Text("orientation: ${if (isPortrait) "portrait" else "landscape"}")
        Text("screenLayout SIZE: $screenLayoutSize")

    }

}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    AutosizeTheme {
        Greeting("Android")
    }
}