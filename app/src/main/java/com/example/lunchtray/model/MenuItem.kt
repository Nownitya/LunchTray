package com.example.lunchtray.model

import java.text.NumberFormat
import java.util.Currency

sealed class MenuItem(
    open val name: String,
    open val description: String,
    open val price: Double
) {
    data class EntreeItem(
        override val name: String,
        override val description: String,
        override val price: Double
    ) : MenuItem(name, description, price)

    data class SideDishItem(
        override val name: String,
        override val description: String,
        override val price: Double
    ) : MenuItem(name, description, price)

    data class AccompanimentItem(
        override val name: String,
        override val description: String,
        override val price: Double
    ) : MenuItem(name, description, price)


    companion object {
        private val rupeeFormat:NumberFormat = NumberFormat.getCurrencyInstance().apply {
            currency = Currency.getInstance("INR")
        }
    }

    fun getFormattedPrice(): String = rupeeFormat.format(price)

}