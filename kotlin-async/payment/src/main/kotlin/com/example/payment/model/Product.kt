package com.example.payment.model

import au.com.console.kassava.kotlinEquals
import au.com.console.kassava.kotlinHashCode
import org.springframework.data.relational.core.mapping.Table

@Table("TB_PROD")
class Product(
    var id: Long = 0,
    var name: String = "",
    var price: Long = 0
): BaseEntity () {
    override fun equals(other: Any?): Boolean {
        return kotlinEquals(other, arrayOf(
            Product::id
        ))
    }

    override fun hashCode(): Int {
        return kotlinHashCode(arrayOf(
            Product::id
        ))
    }
}
