package br.com.saborexpress.sampledata

import br.com.saborexpress.R
import br.com.saborexpress.model.Product
import java.math.BigDecimal

val sampleProducts = listOf(

    Product(
        name = "Hambúrguer Artesanal",
        price = BigDecimal("19.99"),
        image = R.drawable.hamburguer
    ),
    Product(
        name = "Batata Frita",
        price = BigDecimal("7.99"),
        image = R.drawable.batata_frita
    ),
    Product(
        name = "Hot Dog",
        price = BigDecimal("9.99"),
        image = R.drawable.hotdog
    )
)