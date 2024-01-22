package com.example.portfolio.domain.repository

import com.example.portfolio.domain.entity.Achievement
import com.example.portfolio.domain.entity.Link
import com.example.portfolio.domain.entity.Project
import com.example.portfolio.domain.entity.ProjectSkill
import org.springframework.data.jpa.repository.JpaRepository

interface ProjectSkillRepository: JpaRepository<ProjectSkill, Long> {
}