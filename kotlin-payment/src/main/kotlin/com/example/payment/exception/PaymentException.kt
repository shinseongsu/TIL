package com.example.payment.exception

class PaymentException(
    val errorCode: ErrorCode,
    val errorMessage: String
) : RuntimeException()

enum class ErrorCode(val errorMessage: String) {
    INVALID_REQUEST("잘못된 요청입니다."),
    ORDER_NOT_FOUND("해당되는 원거래를 찾을 수 없습니다."),
    CANNOT_REFUND("환불이 불가능한 상태입니다."),
    CANNOT_CANCEL("망취소가 불가능한 상태입니다."),
    EXCEED_REFUNDBLE_AMOUNT("환불 가능한 금액을 초과합니다."),
    PARAMETER_ILLEGAL("잘못된 파라미터 요청입니다."),
    LOACK_BALANCE("잔액이 부족합니다."),
    INTERNAL_SERVER_ERROR("서버 오류입니다."),
}