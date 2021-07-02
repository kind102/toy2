package com.bteam.order.domain.basket.menu

class BasketMenu(val price: Price, val discount: Discount? = null, val options: List<Option>? = null) {
}