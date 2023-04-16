package com.example.kotlinexposed.book.domain

import com.example.kotlinexposed.book.application.dto.BookInfo
import org.jetbrains.exposed.sql.insertAndGetId
import org.jetbrains.exposed.sql.select
import org.jetbrains.exposed.sql.selectAll
import org.jetbrains.exposed.sql.transactions.transaction
import org.springframework.stereotype.Repository

@Repository
class BookRepository {

    fun save(name: String, bookAuthor: Int? = null, bookCorrelationId: Int? = null): Int = transaction {
        Books.insertAndGetId {
            it[title] = name
            it[author] = bookAuthor
            it[correlationId] = bookCorrelationId
        }.value
    }

    fun getBook(id: Int): BookInfo {
        return transaction {
            Books.select { Books.id eq id }
                .single()
                .let {
                    BookInfo.from(it)
                }
        }
    }

    fun getAll(): List<BookInfo> =
        transaction {
            Books.selectAll()
                .map(BookInfo::from)
        }


}