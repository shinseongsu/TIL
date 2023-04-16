package com.example.kotlinexposed.book.application

import com.example.kotlinexposed.book.application.dto.BookInfo
import com.example.kotlinexposed.book.domain.BookRepository
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
@Transactional(readOnly = true)
class BookService(val bookRepository: BookRepository) {

    fun getBook(id: Int) = bookRepository.getBook(id)
    fun getBooks(): List<BookInfo> = bookRepository.getAll()

    @Transactional
    fun save(title: String, author: Int? = null): Int = bookRepository.save(name = title, bookAuthor = author)

}