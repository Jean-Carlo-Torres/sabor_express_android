package br.com.saborexpress.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import br.com.saborexpress.R
import br.com.saborexpress.model.Product
import br.com.saborexpress.sampledata.sampleProducts
import br.com.saborexpress.ui.components.ProductSection
import java.math.BigDecimal

@Composable
fun HomeScreen() {
    Column(
        Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
            .padding(vertical = 16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)

    ) {
        ProductSection("Promoções", listOf(
            Product(
                name = "X-Burguer Artesanal",
                price = BigDecimal("19.99"),
                image = R.drawable.hamburguer
            ),
            Product(
                name = "X-Salada Artesanal",
                price = BigDecimal("21.99"),
                image = R.drawable.hamburguer
            ),
            Product(
                name = "X-Bacon Salada Artesanal",
                price = BigDecimal("24.99"),
                image = R.drawable.hamburguer
            ),
            Product(
                name = "X-Frango Artesanal",
                price = BigDecimal("19.99"),
                image = R.drawable.hamburguer
            )
        ))
        ProductSection("Lanches", sampleProducts)
        ProductSection("Petiscos", sampleProducts)
    }
}

@Preview(showSystemUi = true)
@Composable
private fun HomeScreenPreview() {
    HomeScreen()
}