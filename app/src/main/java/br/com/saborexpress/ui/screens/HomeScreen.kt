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
import br.com.saborexpress.sampledata.sampleSections
import br.com.saborexpress.ui.components.ProductSection
import java.math.BigDecimal

@Composable
fun HomeScreen(
    sections: Map<String, List<Product>>
) {
    Column(
        Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
            .padding(vertical = 16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)

    ) {
        for (section in sections) {
            val title = section.key
            val products = section.value
            ProductSection(
                title = title,
                products = products
            )
        }
    }
}

@Preview(showSystemUi = true)
@Composable
private fun HomeScreenPreview() {
    HomeScreen(sampleSections)
}