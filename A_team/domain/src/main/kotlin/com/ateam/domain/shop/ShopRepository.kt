package com.ateam.domain.shop

import org.bson.types.ObjectId
import org.springframework.data.repository.reactive.ReactiveSortingRepository
import org.springframework.stereotype.Repository

@Repository
interface ShopRepository : ReactiveSortingRepository<Shop, Long>
