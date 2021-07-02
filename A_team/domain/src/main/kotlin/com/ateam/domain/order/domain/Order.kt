package com.ateam.domain.order.domain

import com.ateam.domain.common.ResourceId
import org.bson.types.ObjectId
import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document
import org.springframework.data.mongodb.core.mapping.Field
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono
import reactor.kotlin.core.publisher.toMono

/**
 * ## 주문
 *
 * 주문의 상태는 주문 확인중, 주문접수 완료, 배달중, 배달 완료, 주문 완료가 있다.
 * 주문 완료시 '확인중' 상태
 * 사장님이 접수 시 '주문 접수' 상태
 * 접수후 30분 지나면 '배달중' 자동 변경
 * 배달후 20분 지나면 '배달완료' 자동 변경
 * 배달 완료후 10분후에 '주문 완료' 자동 변경

 * 주문은 접수 전에만 취소 가능 하다.
 */
@Document("order")
class Order private constructor(
    @Id val id: ObjectId = ObjectId(),
    val orderNumber: String,
    val memberId: Long,
    val shopId: ResourceId,
    val requirement: Requirement = Requirement(),
    val delivery: Delivery,
    val orderPayment: OrderPayment,
    val orderCoupon: OrderCoupon?,
    val orderMenus: OrderMenus,
    @Field("orderStatus") private var _orderStatus: OrderStatus = OrderStatus.CART,
    @Field("deliveryStatus") private var _deliveryStatus: DeliveryStatus = DeliveryStatus.EMPTY
) {
    //@Field("orderMenus")
    // private var orderMenus:List<OrderMenu>
    //     get() = this._orderMenus.values
    //     set(value) {
    //         this._orderMenus = OrderMenus()
    //     }

    val orderStatus: OrderStatus
        get() = this._orderStatus

    val deliveryStatus: DeliveryStatus
        get() = this._deliveryStatus

    fun accept() {
        this._orderStatus = OrderStatus.ACCEPTED
    }

    fun complete() {
        this._orderStatus = OrderStatus.COMPLETED
    }

    fun cancel() {
        if (!this._orderStatus.canCancel) {
            return
        }

        this._orderStatus = OrderStatus.CANCELED
    }

    fun startDelivery() {
        this._deliveryStatus = DeliveryStatus.IN_PROGRESS
    }

    fun completeDelivery() {
        this._deliveryStatus = DeliveryStatus.COMPLETED
    }

    fun cancelDelivery() {
        this._deliveryStatus = DeliveryStatus.CANCELED
        cancel()
    }

    companion object {
        fun placeOrder(
            orderNumber: String,
            memberId: Long,
            shopId: ResourceId,
            requirement: Requirement = Requirement(),
            delivery: Delivery,
            orderPayment: OrderPayment,
            orderCoupon: OrderCoupon?,
            orderMenus: OrderMenus,
            orderPlaceValidator: OrderPlaceValidator
        ): Mono<Order> {
            val couponMono: Mono<Void>? = orderCoupon?.let { orderPlaceValidator.validate(orderPayment) };

            return Flux.merge(
                orderPlaceValidator.validate(orderPayment),
                orderPlaceValidator.validate(shopId),
                couponMono ?: Mono.empty(),
            )
                .toMono()
                .map {
                    Order(
                        orderNumber = orderNumber,
                        memberId = memberId,
                        shopId = shopId,
                        requirement = requirement,
                        delivery = delivery,
                        orderPayment = orderPayment,
                        orderCoupon = orderCoupon,
                        orderMenus = orderMenus
                    )
                }
        }
    }
}





