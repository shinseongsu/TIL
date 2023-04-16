package com.example.kotlinexposed.book.domain

import org.jetbrains.exposed.dao.id.IntIdTable

object Books : IntIdTable(name = "book", columnName = "id") {
    val title = varchar("title", length = 200)
    val author = integer("author").nullable()
    val correlationId = integer("correlation_id").nullable()
}