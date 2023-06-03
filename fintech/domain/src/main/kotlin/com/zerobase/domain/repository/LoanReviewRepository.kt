package com.zerobase.domain.repository

import com.zerobase.domain.domain.LoanReview
import org.springframework.data.jpa.repository.JpaRepository

interface LoanReviewRepository: JpaRepository<LoanReview, Long>