package com.bteam.order.domain.basket

class Basket(val diner: BasketDiner, val shop: Shop) {

    private var _menuLine: MenuLine

    fun addMenu(menu: BasketMenu) {
        _menuLine.add()
    }

}