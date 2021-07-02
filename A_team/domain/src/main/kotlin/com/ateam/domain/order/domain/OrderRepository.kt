package com.ateam.domain.order.domain

import org.bson.types.ObjectId
import org.springframework.data.repository.reactive.ReactiveSortingRepository
import org.springframework.stereotype.Repository

@Repository
interface OrderRepository : ReactiveSortingRepository<Order, ObjectId>
