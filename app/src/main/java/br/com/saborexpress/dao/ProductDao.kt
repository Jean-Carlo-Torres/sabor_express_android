package br.com.saborexpress.dao

import br.com.saborexpress.sampledata.sampleProducts

class ProductDao {

    companion object {
        private val products = sampleProducts.toMutableList()
    }

    fun products() = products.toList()
}