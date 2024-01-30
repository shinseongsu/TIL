package com.example.portfolio.domain.repository

import com.example.portfolio.domain.entity.Achievement
import com.example.portfolio.domain.entity.Experience
import com.example.portfolio.domain.entity.Project
import org.springframework.data.jpa.repository.JpaRepository

interface ExperienceRepository: JpaRepository<Experience, Long> {
    fun findAllByIsActive(isActive: Boolean): List<Experience>
}