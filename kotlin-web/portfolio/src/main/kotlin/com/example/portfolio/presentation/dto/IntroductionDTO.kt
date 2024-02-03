package com.example.portfolio.presentation.dto

import com.example.portfolio.domain.entity.Introduction

data class IntroductionDTO(
    val content: String
) {
    constructor(introduction: Introduction): this(
        content = introduction.content
    )
}