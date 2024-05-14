package br.com.saborexpress.ui.activities

import android.icu.text.DecimalFormat
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardCapitalization
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.com.saborexpress.R
import br.com.saborexpress.model.Product
import br.com.saborexpress.ui.theme.SaborExpressTheme
import coil.compose.AsyncImage
import java.math.BigDecimal

class ProductFormActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SaborExpressTheme {
                Surface {
                    ProductFormScreen()
                }
            }
        }
    }
}

@Composable
fun ProductFormScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(start = 16.dp, end = 16.dp)
            .verticalScroll(rememberScrollState()),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        Spacer(modifier = Modifier)
        Text(
            text = "Criando um produto",
            modifier = Modifier.fillMaxWidth(),
            fontSize = 28.sp
        )
        var url by remember {
            mutableStateOf("")
        }
        if (url.isNotBlank()) {
            AsyncImage(
                model = url, contentDescription = null,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(200.dp),
                contentScale = ContentScale.Crop,
                placeholder = painterResource(id = R.drawable.placeholder),
                error = painterResource(id = R.drawable.placeholder)
            )
        }
        TextField(
            value = url,
            onValueChange = {
                url = it
            },
            modifier = Modifier.fillMaxWidth(),
            label = {
                Text(text = "URL da Imagem")
            },
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Uri,
                imeAction = ImeAction.Next
            )
        )

        var name by remember {
            mutableStateOf("")
        }
        TextField(
            value = name,
            onValueChange = {
                name = it
            },
            modifier = Modifier.fillMaxWidth(),
            label = {
                Text(text = "Nome")
            },
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Text,
                imeAction = ImeAction.Next,
                capitalization = KeyboardCapitalization.Words
            )
        )

        var price by remember {
            mutableStateOf("")
        }
        var isPriceError by remember {
            mutableStateOf(false)
        }
        Column {
            TextField(
                value = price,
                onValueChange = {
                    isPriceError = try {
                        BigDecimal(it)
                        false
                    } catch (e: IllegalArgumentException) {
                        it.isNotEmpty()
                    }
                    price = it
                },
                Modifier.fillMaxWidth(),
                isError = isPriceError,
                label = {
                    Text(text = "Preço")
                },
                keyboardOptions =
                KeyboardOptions(
                    keyboardType = KeyboardType.Decimal,
                    imeAction = ImeAction.Next,
                ),
            )
            if (isPriceError) {
                Text(
                    text = "Preço deve ser um número decimal",
                    color = Color.Red,
                    style = MaterialTheme.typography.bodyMedium,
                    modifier = Modifier.padding(start = 16.dp)
                )
            }
        }

        var description by remember {
            mutableStateOf("")
        }
        TextField(
            value = description,
            onValueChange = {
                description = it
            },
            modifier = Modifier
                .fillMaxWidth()
                .heightIn(min = 100.dp),
            label = {
                Text(text = "Descrição")
            },
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Text,
                capitalization = KeyboardCapitalization.Words
            )
        )
        val convertedPrice = try {
            BigDecimal(price)
        } catch (e: NumberFormatException) {
            BigDecimal.ZERO
        }
        Button(
            onClick = {
                val product = Product(
                    name = name,
                    image = url,
                    price = convertedPrice,
                    description = description,
                )
                Log.i("ProductFormActivity", "ProductFormScreen: ${product.price}")
            },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(text = "Salvar")
        }
        Spacer(modifier = Modifier)
    }
}

@Preview
@Composable
private fun ProductFormScreenPreview() {
    SaborExpressTheme {
        Surface {
            ProductFormScreen()
        }
    }
}