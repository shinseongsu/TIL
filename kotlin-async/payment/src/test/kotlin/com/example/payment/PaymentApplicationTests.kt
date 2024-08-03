package com.example.payment

import com.example.payment.model.Order
import com.example.payment.model.Product
import com.example.payment.model.ProductInOrder
import com.example.payment.repository.OrderRepository
import com.example.payment.repository.ProductInOrderRepository
import com.example.payment.repository.ProductRepository
import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe
import mu.KotlinLogging
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.ActiveProfiles

private val logger = KotlinLogging.logger {}

@SpringBootTest
@ActiveProfiles("test")
class PaymentApplicationTests(
    @Autowired productRepository: ProductRepository,
    @Autowired orderRepository: OrderRepository,
    @Autowired productInOrderRepository: ProductInOrderRepository
): StringSpec({
    "context load" {
        val preCnt = productRepository.count()
        productRepository.save(Product(1, "a", 10000).apply { new = true })
        val currCnt = productRepository.count()
        currCnt shouldBe preCnt + 1
    }

    "order" {
        val preCnt = orderRepository.count()
        orderRepository.save(Order(userId = 1)).also { logger.debug { it } }
        val currCnt = orderRepository.count()
        currCnt shouldBe preCnt + 1
    }

    "prod in order" {
        val preCnt = productInOrderRepository.count()
        productInOrderRepository.save(ProductInOrder(1, 1, 1, 1)).also { logger.debug { it } }
        val currCnt = productInOrderRepository.count()
        currCnt shouldBe preCnt + 1
    }
})
