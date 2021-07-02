package com.ateam.domain.order.application

import com.ateam.domain.common.ResourceId
import com.ateam.domain.order.domain.Delivery
import com.ateam.domain.order.domain.Money
import com.ateam.domain.order.domain.OrderMenu
import com.ateam.domain.order.domain.OrderMenus
import com.ateam.domain.order.domain.OrderPayment
import com.ateam.domain.order.domain.PaymentAmount
import com.ateam.domain.order.domain.PaymentMethod
import org.junit.jupiter.api.Disabled
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest

@Disabled
@SpringBootTest
internal class PlaceOrderServiceTest {
    @Autowired
    private lateinit var placeOrderService: PlaceOrderService

    @Test
    fun placeOrderTest() {
        val cart = Cart(
            shopId = ResourceId(System.currentTimeMillis()),
            delivery = Delivery(
                "a", "b", "c"
            ),
            orderPayment = OrderPayment(
                PaymentAmount(
                    Money(1.1),
                    Money(1.2),
                    Money(2.3)
                ),
                PaymentMethod.CARD
            ),
            orderMenus =  OrderMenus(
                values = listOf(
                    OrderMenu(ResourceId(1L), "햄버거", Money(1.1))
                )
            )
        )
        placeOrderService.placeOrder(cart, 1L).block();
    }
}
