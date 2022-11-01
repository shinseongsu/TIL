package com.example.kotlinwebflux.domain

import org.springframework.data.repository.reactive.ReactiveCrudRepository
import reactor.core.publisher.Mono

interface BookRepository : ReactiveCrudRepository<Book, Long> {

    fun findByName(name: String) : Mono<Book>

}