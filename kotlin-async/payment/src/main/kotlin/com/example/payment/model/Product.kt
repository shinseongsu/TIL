package com.example.payment.model

import au.com.console.kassava.kotlinEquals
import au.com.console.kassava.kotlinHashCode
import au.com.console.kassava.kotlinToString
import com.fasterxml.jackson.annotation.JsonIgnore
import org.springframework.beans.factory.annotation.Value
import org.springframework.data.annotation.Id
import org.springframework.data.domain.Persistable
import org.springframework.data.relational.core.mapping.Table

@Table("TB_PROD")
class Product(
    @Id
    var id: Long = 0,
    var name: String = "",
    var price: Long = 0
): BaseEntity(), Persistable<Long> {
    override fun equals(other: Any?): Boolean = kotlinEquals(other, arrayOf(
        Product::id
    ))

    override fun hashCode(): Int = kotlinHashCode(arrayOf(
        Product::id
    ))

    override fun toString(): String = kotlinToString(arrayOf(
        Product::id,
        Product::name,
        Product::price
    ), superToString = { super.toString() })

    override fun getId(): Long {
        return id
    }

    @Value("null")
    @JsonIgnore
    var new: Boolean = false

    override fun isNew(): Boolean {
        return new
    }
}
