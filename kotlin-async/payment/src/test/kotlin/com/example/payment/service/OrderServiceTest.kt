package com.example.payment.service

import com.example.payment.model.Product
import com.example.payment.repository.ProductRepository
import io.kotest.core.spec.style.StringSpec
import mu.KotlinLogging
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.ActiveProfiles

private val logger = KotlinLogging.logger {}

@SpringBootTest
@ActiveProfiles("test")
class OrderServiceTest(
    @Autowired orderService: OrderService,
    @Autowired productRepository: ProductRepository,
): StringSpec({

    beforeTest {
        productRepository.save(Product(1, "apple", 1000).apply { new = true })
        productRepository.save(Product(2, "banana", 1200).apply { new = true })
        productRepository.save(Product(3, "mango", 700).apply { new = true })
        productRepository.save(Product(4, "orange", 2100).apply { new = true })
    }

    "create" {
        val request = ReqCreateOrder(
            11, listOf(
                ReqProdQuantity(1, 1),
                ReqProdQuantity(2, 2),
                ReqProdQuantity(3, 3),
                ReqProdQuantity(4, 4),
                ReqProdQuantity(5, 5),
            )
        )

        val order = orderService.create(request).also { logger.debug { it } }


    }

})
