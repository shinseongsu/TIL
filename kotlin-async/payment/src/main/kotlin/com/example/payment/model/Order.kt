package com.example.payment.model

import au.com.console.kassava.kotlinEquals
import au.com.console.kassava.kotlinHashCode
import au.com.console.kassava.kotlinToString
import org.springframework.data.annotation.Id
import org.springframework.data.relational.core.mapping.Table

@Table("TB_ORDER")
class Order(
    @Id
    var id: Long = 0,
    var userId: Long,
    var description: String? = null,
    var amount: Long = 0,
    var pgOrderId: String? = null,
    var pgKey: String? = null,
    var pgStatus: PgStatus = PgStatus.CREATE,
    var pgRetryCount: Int = 0,
) : BaseEntity() {
    override fun equals(other: Any?): Boolean = kotlinEquals(other, arrayOf(
        Order::id
    ))

    override fun hashCode(): Int = kotlinHashCode(arrayOf(
        Order::id
    ))

    override fun toString(): String = kotlinToString(arrayOf(
        Order::id,
        Order::userId,
        Order::description
    ), superToString = { super.toString() })
}
