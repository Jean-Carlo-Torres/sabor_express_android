package br.com.saborexpress.model

import androidx.annotation.DrawableRes
import br.com.saborexpress.R
import java.math.BigDecimal

class Product(
    val name: String,
    val price: BigDecimal,
    @DrawableRes val image: Int
)