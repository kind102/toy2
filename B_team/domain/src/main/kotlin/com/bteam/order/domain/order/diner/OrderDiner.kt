package com.bteam.order.domain.order.diner

import com.bteam.order.domain.common.type.Address
import com.bteam.order.domain.common.type.PhoneNumber

class OrderDiner(val dinerId: Long, val contact: PhoneNumber, val address: Address) {
}