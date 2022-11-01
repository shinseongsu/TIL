package com.example.kotlinwebflux.domain

import org.springframework.data.annotation.Id
import org.springframework.data.relational.core.mapping.Column
import org.springframework.data.relational.core.mapping.Table

@Table
data class Book(

    @Id
    val id: Long? = null,

    @Column
    val name: String,

    @Column
    val price: Int,

)