package com.ateam.domain.order.domain

data class OrderCoupon(
    val couponId: Long,
    val discountAmount: Money,
    val discountType: String
) {
}
