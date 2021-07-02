package com.ateam.domain.order.domain

data class PaymentAmount(
    val subTotalAmount : Money,
    val deliveryFee: Money,
    val paymentAmount: Money,
){

}
