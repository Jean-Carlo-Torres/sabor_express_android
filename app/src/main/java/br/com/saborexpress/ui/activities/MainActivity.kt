package br.com.saborexpress.ui.activities

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import br.com.saborexpress.dao.ProductDao
import br.com.saborexpress.sampledata.sampleCandies
import br.com.saborexpress.sampledata.sampleDrinks
import br.com.saborexpress.sampledata.sampleSections
import br.com.saborexpress.ui.screens.HomeScreen
import br.com.saborexpress.ui.theme.SaborExpressTheme

class MainActivity : ComponentActivity() {

    private val dao = ProductDao()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            App(onFabClick = {
                startActivity(
                    Intent(
                        this,
                        ProductFormActivity::class.java
                    )
                )
            }){
                val sections = mapOf(
                    "Todos produtos" to dao.products(),
                    "Promoções" to sampleDrinks + sampleCandies,
                    "Bebidas" to sampleDrinks,
                    "Doces" to sampleCandies
                )
HomeScreen(sections = sections)
            }
        }
    }
}

@Composable
fun App(
    onFabClick: () -> Unit = {},
    content: @Composable () -> Unit = {}
) {
    SaborExpressTheme {
        Surface {
            Scaffold(
                floatingActionButton = {
                    FloatingActionButton(
                        onClick = onFabClick,
                        containerColor = Color.Red,
                        contentColor = Color.White
                    ) {
                        Icon(
                            imageVector = Icons.Default.Add,
                            contentDescription = "Adicionar Produto"
                        )
                    }
                }
            ) { paddingValues ->
                Box(modifier = Modifier.padding(paddingValues)) {
                    content()
                }
            }
        }
    }
}

@Preview
@Composable
private fun AppPreview() {
    App {
        HomeScreen(sections = sampleSections)
    }
}