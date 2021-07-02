package com.ateam.domain.order.application

import com.ateam.domain.common.ResourceId
import com.ateam.domain.order.domain.Delivery
import com.ateam.domain.order.domain.OrderCoupon
import com.ateam.domain.order.domain.OrderMenus
import com.ateam.domain.order.domain.OrderPayment
import com.ateam.domain.order.domain.Requirement

data class Cart(
    val shopId: ResourceId,
    val requirement: Requirement = Requirement(),
    val delivery: Delivery,
    val orderPayment: OrderPayment,
    val orderCoupon: OrderCoupon? = null,
    val orderMenus: OrderMenus,
) {

}
