package com.ateam.domain.order.domain

/**
 *  * 결제
 * 결제 금액에는 소계, 배달료, 소액 주문 수수료, 최종 결제 금액 등이 있다.
 * 결제 수단 선택(필수)
 */
data class OrderPayment(
    val paymentAmount: PaymentAmount,
    val paymentMethod: PaymentMethod,
) {

}

