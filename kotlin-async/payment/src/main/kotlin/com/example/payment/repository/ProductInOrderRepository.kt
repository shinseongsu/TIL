package com.example.payment.repository

import com.example.payment.model.ProductInOrder
import org.springframework.data.repository.kotlin.CoroutineCrudRepository
import org.springframework.stereotype.Repository

@Repository
interface ProductInOrderRepository: CoroutineCrudRepository<ProductInOrder, Long> {
}
