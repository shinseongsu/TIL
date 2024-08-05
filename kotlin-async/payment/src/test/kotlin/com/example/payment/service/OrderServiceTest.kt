package com.example.payment.service

import com.example.payment.exception.NoProductFound
import com.example.payment.model.Product
import com.example.payment.repository.ProductInOrderRepository
import com.example.payment.repository.ProductRepository
import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe
import io.kotest.matchers.shouldNotBe
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
    @Autowired productInOrderRepository: ProductInOrderRepository
): StringSpec({

    beforeTest {
        productRepository.save(Product(1, "apple", 1000).apply { new = true })
        productRepository.save(Product(2, "banana", 1200).apply { new = true })
        productRepository.save(Product(3, "mango", 700).apply { new = true })
        productRepository.save(Product(4, "orange", 2100).apply { new = true })
    }

    "create on fail" {
        val request = ReqCreateOrder(
            11, listOf(
                ReqProdQuantity(1, 1),
                ReqProdQuantity(2, 2),
                ReqProdQuantity(3, 3),
                ReqProdQuantity(4, 4),
                ReqProdQuantity(5, 5),
            )
        )

        shouldThrow<NoProductFound> {
            orderService.create(request)
        }
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

        order.amount shouldBe 13900
        order.description shouldNotBe null
        order.pgOrderId shouldNotBe null

        productInOrderRepository.countByOrderId(order.id) shouldBe 4
    }

})
