package com.ateam.domain.order.domain

enum class OrderStatus {
    CART,
    OPEN,
    ACCEPTED,
    COMPLETED,
    CANCELED;

    val canCancel: Boolean get() = this == CART || this == OPEN
}
