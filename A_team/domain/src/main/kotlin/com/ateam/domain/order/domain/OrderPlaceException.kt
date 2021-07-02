package com.ateam.domain.order.domain

class OrderPlaceException(errorType: ErrorType) : IllegalStateException(errorType.name) {
}

enum class ErrorType{
    SHOP,
    COUPON,
    PAYMENT
}
