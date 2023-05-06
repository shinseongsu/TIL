package com.example.kotlinreactive.response

data class PagingResponse<T>(
    val total: Long,
    val time: List<T>
)
