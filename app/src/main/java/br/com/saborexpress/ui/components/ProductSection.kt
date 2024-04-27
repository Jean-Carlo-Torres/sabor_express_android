package br.com.saborexpress.ui.components

import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.com.saborexpress.R
import br.com.saborexpress.model.Product
import br.com.saborexpress.sampledata.sampleProducts
import br.com.saborexpress.ui.theme.SaborExpressTheme
import java.math.BigDecimal

@Composable
fun ProductSection(title: String, products: List<Product>) {
    Column {
        Text(
            text = title,
            Modifier.padding(start = 16.dp, end = 16.dp),
            fontSize = 20.sp,
            fontWeight = FontWeight(400)
        )
        Row(
            modifier = Modifier
                .padding(top = 8.dp)
                .fillMaxWidth()
                .horizontalScroll(rememberScrollState())
                .padding(horizontal = 16.dp),
            horizontalArrangement = Arrangement.spacedBy(16.dp)

        ) {
            for (p in products) {
                ProductItem(p)
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun ProductSectionPreview() {
    SaborExpressTheme {
        Surface {
            ProductSection("Promoções", products = sampleProducts)
        }
    }

}


