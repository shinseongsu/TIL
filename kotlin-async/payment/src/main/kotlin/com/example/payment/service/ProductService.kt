package com.example.payment.service

import com.example.payment.config.CacheKey
import com.example.payment.config.CacheManager
import com.example.payment.model.Product
import com.example.payment.repository.ProductRepository
import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Service
import kotlin.time.Duration.Companion.minutes

@Service
class ProductService(
    private val productRepository: ProductRepository,
    private val cacheManager: CacheManager,
    @Value("\${spring.active.profile:local")
    private val profile: String
) {

    val CACHE_KEY = "${profile}/payment/product".also { cacheManager.ttl[it] = 10.minutes }

    suspend fun get(productId: Long): Product? {
        val key = CacheKey(CACHE_KEY, productId)

        return cacheManager.get(key) {
            productRepository.findById(productId)
        }
    }
}
