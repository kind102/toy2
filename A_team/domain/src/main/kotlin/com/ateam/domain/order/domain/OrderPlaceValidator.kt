package com.ateam.domain.order.domain

import com.ateam.domain.common.ResourceId
import reactor.core.publisher.Mono

interface OrderPlaceValidator {
    fun validate(orderPayment: OrderPayment): Mono<Void>
    fun validate(orderCoupon: OrderCoupon): Mono<Void>
    fun validate(shopResourceId: ResourceId): Mono<Void>
}
