package com.example.kotlinwebflux.ui

import com.example.kotlinwebflux.domain.Book
import com.example.kotlinwebflux.domain.BookRepository
import org.springframework.web.bind.annotation.*
import reactor.core.publisher.Mono

@RestController("/book")
class BookApiController(
    val bookRepository: BookRepository,
) {

    @GetMapping("{name}")
    fun getByName(@PathVariable name: String): Mono<Book> {
        return bookRepository.findByName(name)
    }

    @PostMapping
    fun craete(@RequestBody map : Map<String, Any>) : Mono<Book> {
        val book = Book (
            name = map["name"].toString(),
            price = map["price"] as Int
        )
        return bookRepository.save(book)
    }

}