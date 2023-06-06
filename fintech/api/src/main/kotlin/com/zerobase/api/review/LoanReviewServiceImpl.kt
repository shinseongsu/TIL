package com.zerobase.api.review

import com.zerobase.domain.repository.LoanReviewRepository
import org.springframework.stereotype.Service

@Service
class LoanReviewServiceImpl(
    private val loanReviewRepository: LoanReviewRepository
): LoanReviewService {

    override fun loanReviewMain(userKey: String): LoanReviewDto.LoanReviewResponseDto {
        val loanResult = getLoanResult(userKey)

        return LoanReviewDto.LoanReviewResponseDto(
            userKey = userKey,
            loanResult = LoanReviewDto.LoanResult(
                userLimitAmount = loanResult.userLimitAmount,
                userLoanInterest = loanResult.userLoanInterest
            )
        )

    }

    override fun getLoanResult(userKey: String): LoanReviewDto.LoanReview {
        val loanReview = loanReviewRepository.findByUserKey(userKey)

        return LoanReviewDto.LoanReview(
            loanReview.userKey,
            loanReview.loanLimitedAmount,
            loanReview.loanInterest
        )
    }
}