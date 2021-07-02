package com.ateam.domain.order.domain

data class Delivery(
    val address: String,
    val addressDetail: String,
    val contact: String
) {
    init {
        require(address.isNotBlank())
        require(addressDetail.isNotBlank())
        require(contact.isNotBlank())
    }
}
