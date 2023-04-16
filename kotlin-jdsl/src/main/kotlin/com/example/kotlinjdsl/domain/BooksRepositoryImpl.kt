package com.example.kotlinjdsl.domain

import com.linecorp.kotlinjdsl.QueryFactory
import com.linecorp.kotlinjdsl.querydsl.expression.column
import com.linecorp.kotlinjdsl.listQuery
import com.linecorp.kotlinjdsl.singleQuery
import org.springframework.stereotype.Repository

@Repository
class BooksRepositoryImpl(
    private val queryFactory: QueryFactory
) : BooksRepositoryCustom {
    override fun findBooks(): List<Books> = queryFactory.listQuery {
        select(entity(Books::class))
        from(entity(Books::class))
    }

    override fun findBooksByName(name: String): Books {
        return queryFactory.singleQuery<Books> {
            select(entity(Books::class))
                from(entity(Books::class))
            where(column(Books::name).equal(name))
        }
    }
}