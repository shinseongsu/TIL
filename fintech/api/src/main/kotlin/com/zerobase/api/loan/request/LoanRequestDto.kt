package com.zerobase.api.loan.request

class LoanRequestDto {

    data class LoanRequestInfoDto(
        val userName: String,
        val userIncomeAmount: Long,
        var userRegistrationNumber: String
    ) {
        fun toUserInfoDto(userKey: String) =
            UserInfoDto(
                userKey, userName, userRegistrationNumber, userIncomeAmount
            )
    }

    data class LoanRequestResponseDto(
        val userKey: String
    )

}