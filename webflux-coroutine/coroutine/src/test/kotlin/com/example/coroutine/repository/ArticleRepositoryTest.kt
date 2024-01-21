package com.example.coroutine.repository

import com.example.coroutine.model.Article
import kotlinx.coroutines.runBlocking
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest

@SpringBootTest
class ArticleRepositoryTest(
    @Autowired private val repository: ArticleRepository
) {

    @Test
    fun count() {
        runBlocking {
            val prev = repository.count()
            repository.save(Article(title = "title1"))
            val curr = repository.count()
            Assertions.assertEquals(prev + 1, curr)
        }
    }

}