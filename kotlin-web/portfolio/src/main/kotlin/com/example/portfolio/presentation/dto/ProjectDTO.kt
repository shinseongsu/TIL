package com.example.portfolio.presentation.dto

import com.example.portfolio.domain.entity.Project

data class ProjectDTO(
    val name: String,
    val description: String,
    val startYearMonth: String,
    val endYearMonth: String,
    val details: List<ProjectDetailDTO>,
    val skills: List<SkillDTO>?
) {

    constructor(project: Project): this(
        name = project.name,
        description = project.description,
        startYearMonth = "${project.startYear}.${project.startMonth}",
        endYearMonth = project.getEndYearMonth(),
        details = project.details.filter { it.isActive }.map { ProjectDetailDTO(it) },
        skills = project.skills.map { it.skill }.filter { it.isActive }.map{ SkillDTO(it) }
    )


}