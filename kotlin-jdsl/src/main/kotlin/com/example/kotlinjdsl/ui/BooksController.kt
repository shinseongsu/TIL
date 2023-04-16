package com.example.kotlinjdsl.ui

import com.example.kotlinjdsl.application.BooksService
import com.example.kotlinjdsl.domain.Books
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RestController
import kotlin.random.Random

@RestController
class BooksController(
    private val booksService: BooksService
) {

    @GetMapping("books/{name}")
    fun findBooksByName(@PathVariable name: String): Books {
        return booksService.findByName(name)
    }

    @PostMapping("books")
    fun save(): Books {
        return booksService.save(Random(100).toString())
    }
}