package com.ateam.domain.shop

import org.bson.types.ObjectId
import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document

@Document("shop")
class Shop(
    @Id val id: Long = System.currentTimeMillis(),
    val name:String
) {
    val isLive:Boolean get() = true
}
