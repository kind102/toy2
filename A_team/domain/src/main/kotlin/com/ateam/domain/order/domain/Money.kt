package com.ateam.domain.order.domain

data class Money(
    val value : Double
) {
    init {
        require(value >= 0.0)
    }
}
