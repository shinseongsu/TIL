package com.example.kotlinjdsl.domain

import org.springframework.data.jpa.repository.JpaRepository

interface BooksRepository: JpaRepository<Books, Long>, BooksRepositoryCustom {
}