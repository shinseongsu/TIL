package com.zerobase.api.loan.request

import com.zerobase.domain.domain.UserInfo

interface LoanRequestService {
    fun loanRequestMain(
        loanRequestInputDto: LoanRequestDto.LoanRequestInfoDto
    ): LoanRequestDto.LoanRequestResponseDto

    fun saveUserInfo(userInfoDto: UserInfoDto) : UserInfo

    fun loanRequestReview(userKey: String)
}