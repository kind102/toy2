package com.ateam.domain.order.domain

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

internal class OrderMenusTest{

    @Test
    fun `주문 메뉴는 한가지 이상이어야 한다`(){
        assertThrows<IllegalArgumentException> {
            OrderMenus(listOf())
        }
    }
}
