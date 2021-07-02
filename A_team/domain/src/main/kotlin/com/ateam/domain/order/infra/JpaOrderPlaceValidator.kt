package com.ateam.domain.order.infra

import com.ateam.domain.common.ResourceId
import com.ateam.domain.order.domain.OrderCoupon
import com.ateam.domain.order.domain.OrderPayment
import com.ateam.domain.order.domain.OrderPlaceValidator
import com.ateam.domain.shop.Shop
import com.ateam.domain.shop.ShopRepository
import org.springframework.stereotype.Service
import reactor.core.publisher.Mono
import reactor.kotlin.core.publisher.switchIfEmpty

@Service
class JpaOrderPlaceValidator(
    private val shopRepository: ShopRepository
) : OrderPlaceValidator {

    override fun validate(orderPayment: OrderPayment): Mono<Void> {
        return Mono.empty<Void>()//Mono.just("orderCoupon").then()
            .switchIfEmpty() { Mono.empty()}
            .log("orderPayment");
    }

    override fun validate(orderCoupon: OrderCoupon): Mono<Void> {
        return Mono.empty<Void?>()
            .log("orderCoupon")
    }

    override fun validate(shopId: ResourceId): Mono<Void> {
        return shopRepository.findById(shopId.value)
            .log("shopId")
            .switchIfEmpty() { Mono.just(Shop(name = "emptyShop")) }
            .flatMap { shop -> if (shop.isLive) Mono.empty<Void>() else Mono.error(IllegalStateException()) }
    }
}
