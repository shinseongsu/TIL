package com.example.portfolio.domain.repository

import com.example.portfolio.domain.entity.Achievement
import com.example.portfolio.domain.entity.Link
import com.example.portfolio.domain.entity.Project
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import java.util.Optional

interface ProjectRepository: JpaRepository<Project, Long> {

    @Query("select p from Project p left join fetch p.skills s left join fetch s.skill where p.isActive = :isActive ")
    fun findAllByIsActive(isActive: Boolean): List<Project>

    @Query("select p from Project p left join fetch p.details where p.id = :id ")
    override fun findById(id: Long): Optional<Project>

}