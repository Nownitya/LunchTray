package com.example.lunchtray.model

import com.example.lunchtray.model.MenuItem.AccompanimentItem
import com.example.lunchtray.model.MenuItem.EntreeItem
import com.example.lunchtray.model.MenuItem.SideDishItem

data class OrderUiState(
    val entree: EntreeItem? = null,
    val sideDish: SideDishItem? = null,
    val accompaniment: AccompanimentItem? = null,
    val itemTotalPrice: Double = 0.0,
    val orderTax: Double = 0.0,
    val orderTotalPrice: Double = 0.0
)