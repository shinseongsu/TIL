package com.zerobase.api.review

import com.zerobase.api.exception.CustomErrorCode
import com.zerobase.api.exception.CustomException
import com.zerobase.domain.domain.LoanReview
import com.zerobase.domain.repository.LoanReviewRepository
import org.springframework.stereotype.Service

@Service
class LoanReviewServiceImpl(
    private val loanReviewRepository: LoanReviewRepository
): LoanReviewService {

    override fun loanReviewMain(userKey: String): LoanReviewDto.LoanReviewResponseDto {
        return LoanReviewDto.LoanReviewResponseDto(
            userKey = userKey,
            loanResult = getLoanResult(userKey)?.toResponseDto()
                ?: throw CustomException(CustomErrorCode.RESULT_NOT_FOUND)
        )

    }

    override fun getLoanResult(userKey: String) =
        loanReviewRepository.findByUserKey(userKey)

    private fun LoanReview.toResponseDto() =
        LoanReviewDto.LoanResult(
            userLimitAmount = this.loanLimitedAmount,
            userLoanInterest = this.loanInterest
        )

}