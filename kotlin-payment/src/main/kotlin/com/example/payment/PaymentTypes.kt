package com.example.payment

enum class OrderStatus {
    CREATED,
    FAILED,
    PAID,
    CANCELED,
    PARTIAL_REFUNDED,
    REFUNDED
}

enum class TransactionType {
    PAYMENT, REFUND, CANCEL
}

enum class TranscationStatus {
    RESERVE, SUCCESS, FAILURE
}