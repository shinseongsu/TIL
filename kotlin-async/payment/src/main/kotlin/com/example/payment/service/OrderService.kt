package com.example.payment.service

import com.example.payment.exception.NoProductFound
import com.example.payment.model.Order
import com.example.payment.model.PgStatus
import com.example.payment.model.ProductInOrder
import com.example.payment.repository.OrderRepository
import com.example.payment.repository.ProductInOrderRepository
import com.example.payment.repository.ProductRepository
import kotlinx.coroutines.flow.toList
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import java.util.UUID

@Service
class OrderService(
    private val orderRepository: OrderRepository,
    private val productService: ProductService,
    private val productRepository: ProductRepository,
    private val productInOrderRepository: ProductInOrderRepository,
) {

    @Transactional
    suspend fun create(request: ReqCreateOrder): Order {
        val prodIds = request.products.map { it.prodId }.toSet()
        val productsById = productRepository.findAllById(prodIds).toList().associateBy { it.id }
        prodIds.filter { !productsById.containsKey(it) }.let { remains ->
            if(remains.isNotEmpty()) {
                throw NoProductFound("prod ids: $remains")
            }
        }

        val amount = request.products.map { productsById[it.prodId]!!.price * it.quantity }.sum()
        val description = request.products.joinToString(", ") { "${productsById[it.prodId]!!.name} x ${it.quantity}" }

        val newOrder = orderRepository.save(Order(
            userId = request.userId,
            description = description,
            amount = amount,
            pgOrderId = "${UUID.randomUUID()}".replace("-", ""),
            pgStatus = PgStatus.CREATE,
        ))

        request.products.forEach {
            productInOrderRepository.save( ProductInOrder(
                orderId = newOrder.id,
                prodId = it.prodId,
                price = productsById[it.prodId]!!.price,
                quantity = it.quantity,
            ))
        }

        return newOrder
    }

}

data class ReqCreateOrder(
    val userId: Long,
    var products: List<ReqProdQuantity>
)

data class ReqProdQuantity(
    val prodId: Long,
    val quantity: Int
)
