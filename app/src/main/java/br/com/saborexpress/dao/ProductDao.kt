package br.com.saborexpress.dao

import androidx.compose.runtime.mutableStateListOf
import br.com.saborexpress.model.Product
import br.com.saborexpress.sampledata.sampleProducts

class ProductDao {

    companion object {
        private val products = mutableStateListOf<Product>()
    }

    fun products() = products.toList()
    fun save(product: Product) {
        products.add(product)
    }
}