package com.example.payment.exception

import mu.KotlinLogging
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.RestControllerAdvice

private val log = KotlinLogging.logger { }

@RestControllerAdvice
class GlobalExceptionHandler {

    @ExceptionHandler(PaymentException::class)
    fun handlePaymentException(e: PaymentException): ErrorResponse {
        log.error(e) { "${e.errorCode} is occurred." }
        return ErrorResponse(e.errorCode, e.errorMessage)
    }

    @ExceptionHandler(Exception::class)
    fun handleException(
        e: Exception
    ): ErrorResponse {
        log.error(e) { "Exception is occurred." }
        return ErrorResponse(ErrorCode.INTERNAL_SERVER_ERROR)
    }
}

class ErrorResponse(
    val errorCode: ErrorCode,
    val errorMessage: String = errorCode.errorMessage
)