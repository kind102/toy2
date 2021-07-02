package com.ateam.api.ui

import com.ateam.domain.order.application.Cart
import com.ateam.domain.order.application.PlaceOrderService
import com.ateam.domain.order.domain.Order
import com.ateam.domain.order.domain.OrderRepository
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono

@RestController
class OrderController(
    private val orderRepository: OrderRepository,
    private val placeOrderService: PlaceOrderService
) {

    @GetMapping("/orders")
    fun list(): Flux<Order> {
        return orderRepository.findAll().log()
    }

    @PostMapping("/orders")
    fun placeOrder(@RequestBody cart: Cart): Mono<String> {
        return placeOrderService.placeOrder(cart, System.currentTimeMillis()).map { it.toHexString() }
    }
}


