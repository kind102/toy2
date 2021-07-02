package com.bteam.order.domain.order

import com.bteam.order.domain.order.diner.OrderDiner
import com.bteam.order.domain.order.promotion.OrderPromotion
import com.bteam.order.domain.order.rider.OrderRider
import com.bteam.order.domain.order.shop.OrderShop

class Order(val diner: OrderDiner, val shop: OrderShop, val promotion: OrderPromotion, val requestMemo: RequestMemo? = null) {

    private var rider: OrderRider

    fun assignRider(assignedRider: OrderRider) {
        rider = assignedRider
    }
}