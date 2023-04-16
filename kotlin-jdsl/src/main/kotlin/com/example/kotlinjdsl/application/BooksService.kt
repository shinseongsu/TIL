package com.example.kotlinjdsl.application

import com.example.kotlinjdsl.domain.Books
import com.example.kotlinjdsl.domain.BooksRepository
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
@Transactional(readOnly = true)
class BooksService(
    private val booksRepository: BooksRepository
) {

    @Transactional
    fun save(bookName: String): Books {
        return booksRepository.save(Books(name = bookName))
    }

    fun findByName(bookName: String): Books {
        return booksRepository.findBooksByName(bookName)
    }
}