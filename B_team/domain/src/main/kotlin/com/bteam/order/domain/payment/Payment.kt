package com.bteam.order.domain.payment

import com.bteam.order.domain.common.type.Money

class Payment(val orderId: Long, val paymentType: PaymentType, val totalAmount: Money) {
}