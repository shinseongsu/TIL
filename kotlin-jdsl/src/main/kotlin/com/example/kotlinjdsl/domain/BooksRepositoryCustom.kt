package com.example.kotlinjdsl.domain

interface BooksRepositoryCustom {
    fun findBooks(): List<Books>
    fun findBooksByName(name: String): Books
}