package com.example.kotlinexposed.book.ui

import com.example.kotlinexposed.book.application.BookService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RestController
import kotlin.random.Random

@RestController
class BookController(val bookService: BookService) {

    @GetMapping("/book/{id}")
    fun getBook(@PathVariable id: Int) = bookService.getBook(id)

    @GetMapping("books")
    fun getBooks() = bookService.getBooks()

    @PostMapping("/book")
    fun saveBook() = bookService.save(title = "Book-" + Random(100).nextLong())

}