package com.ateam.domain.order.domain

import com.ateam.domain.common.ResourceId

data class OrderMenu(
    val menuId: ResourceId,
    val name: String,
    val price: Money
) {
}
