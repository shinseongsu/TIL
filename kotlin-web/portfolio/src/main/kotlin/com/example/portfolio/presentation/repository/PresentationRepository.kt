package com.example.portfolio.presentation.repository

import com.example.portfolio.domain.entity.Achievement
import com.example.portfolio.domain.entity.Experience
import com.example.portfolio.domain.entity.Introduction
import com.example.portfolio.domain.entity.Link
import com.example.portfolio.domain.entity.Project
import com.example.portfolio.domain.entity.Skill
import com.example.portfolio.domain.repository.AchievementRepository
import com.example.portfolio.domain.repository.ExperienceRepository
import com.example.portfolio.domain.repository.IntroductionRepository
import com.example.portfolio.domain.repository.LinkRepository
import com.example.portfolio.domain.repository.ProjectRepository
import com.example.portfolio.domain.repository.SkillRepository
import org.springframework.stereotype.Repository

@Repository
class PresentationRepository(
    private val achievementRepository: AchievementRepository,
    private val introductionRepository: IntroductionRepository,
    private val linkRepository: LinkRepository,
    private val skillRepository: SkillRepository,
    private val projectRepository: ProjectRepository,
    private val experienceRepository: ExperienceRepository
) {

    fun getActiveAchievements(): List<Achievement> {
        return achievementRepository.findAllByIsActive(true)
    }

    fun getActiveExperience(): List<Experience> {
        return experienceRepository.findAllByIsActive(true)
    }

    fun getActiveIntroduction(): List<Introduction> {
        return introductionRepository.findAllByIsActive(true)
    }

    fun getActiveLink(): List<Link> {
        return linkRepository.findAllByIsActive(true)
    }

    fun getActiveProject(): List<Project> {
        return projectRepository.findAllByIsActive(true)
    }

    fun getActiveSkill(): List<Skill> {
        return skillRepository.findAllByIsActive(true)
    }

}