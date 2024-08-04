package com.example.payment.service

import com.example.payment.model.Product
import com.example.payment.repository.ProductRepository
import org.springframework.stereotype.Service

@Service
class ProductService(
    private val productRepository: ProductRepository
) {

    suspend fun get(productId: Long): Product? {
        return productRepository.findById(productId)
    }
}
