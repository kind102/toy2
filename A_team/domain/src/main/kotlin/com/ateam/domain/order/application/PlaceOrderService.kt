package com.ateam.domain.order.application

import com.ateam.domain.order.domain.Order
import com.ateam.domain.order.domain.OrderPlaceValidator
import com.ateam.domain.order.domain.OrderRepository
import org.bson.types.ObjectId
import org.springframework.stereotype.Service
import reactor.core.publisher.Mono

@Service
class PlaceOrderService(
    private val orderPlaceValidator: OrderPlaceValidator,
    private val orderRepository: OrderRepository
) {
    fun placeOrder(cart: Cart, memberId: Long): Mono<ObjectId> {
        return Order
            .placeOrder(
                orderNumber = "abcd",
                memberId = memberId,
                shopId = cart.shopId,
                requirement = cart.requirement,
                delivery = cart.delivery,
                orderPayment = cart.orderPayment,
                orderCoupon = cart.orderCoupon,
                orderMenus = cart.orderMenus,
                orderPlaceValidator = orderPlaceValidator
            )
            .flatMap { orderRepository.save(it) }
            .map { it.id }

        // return orderMono
        //     .flatMap(orderRepository::save)
        //     .map { it.id }
    }
}
