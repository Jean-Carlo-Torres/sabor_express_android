package br.com.saborexpress.ui.activities

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import br.com.saborexpress.sampledata.sampleSections
import br.com.saborexpress.ui.screens.HomeScreen
import br.com.saborexpress.ui.theme.SaborExpressTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            App()
        }
    }
}

@Composable
fun App() {
    SaborExpressTheme {
        Surface {
            HomeScreen(
                sampleSections
            )
        }
    }
}