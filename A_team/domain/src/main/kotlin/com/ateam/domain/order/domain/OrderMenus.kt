package com.ateam.domain.order.domain

data class OrderMenus(
     val values: List<OrderMenu>
) {
    init {
        require(values.isNotEmpty())
    }
}
