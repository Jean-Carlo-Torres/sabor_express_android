package br.com.saborexpress.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import br.com.saborexpress.model.Product
import br.com.saborexpress.sampledata.sampleSections
import br.com.saborexpress.ui.components.ProductSection

@Composable
fun HomeScreen(
    sections: Map<String, List<Product>>
) {
    Column {
        var text by remember { mutableStateOf("") }
        OutlinedTextField(
            value = text,
            onValueChange = { value ->
                text = value
            },
            Modifier
                .padding(
                    start = 16.dp,
                    end = 16.dp,
                    top = 16.dp
                )
                .fillMaxWidth(),
            shape = RoundedCornerShape(100),
            leadingIcon = {
                Icon(
                    Icons.Filled.Search, contentDescription = "Icone de lupa"
                )
            },
            label = {
                Text("Pesquisar")
            },
            placeholder = {
                Text("O que você procura?")
            }
        )
        LazyColumn(
            Modifier
                .fillMaxSize()
                .padding(vertical = 16.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp)

        ) {
            for (section in sections) {
                val title = section.key
                val products = section.value
                item {
                    ProductSection(
                        title = title,
                        products = products
                    )
                }
            }
        }
    }
}

@Preview(showSystemUi = true)
@Composable
private fun HomeScreenPreview() {
    HomeScreen(sampleSections)
}