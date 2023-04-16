package com.example.kotlinexposed.book.application.dto

import com.example.kotlinexposed.book.domain.Books
import org.jetbrains.exposed.sql.ResultRow

data class BookInfo(
    val id: Int,
    val title: String,
    val author: Int?
) {

    companion object {
        fun from(resultRow: ResultRow)  =
            BookInfo(resultRow[Books.id].value, resultRow[Books.title], resultRow[Books.author])
    }

}
