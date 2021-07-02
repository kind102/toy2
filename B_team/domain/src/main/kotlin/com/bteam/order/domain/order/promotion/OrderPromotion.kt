package com.bteam.order.domain.order.promotion

import com.bteam.order.domain.common.type.Money
import java.math.BigDecimal

class OrderPromotion(val promotionId: Long, val promotionType: OrderPromotionType, val discountAmount: Money? = null, val discountRate: BigDecimal? = null) {
}