package com.example.portfolio.presentation.dto

data class IntroductionDTO(
    val content: String
) {
    constructor(introductionDTO: IntroductionDTO): this(
        content = introductionDTO.content
    )
}