package com.kotlinspring.kotlinspringboot.service

import com.kotlinspring.kotlinspringboot.dto.CourseDTO
import com.kotlinspring.kotlinspringboot.entity.Course
import com.kotlinspring.kotlinspringboot.repository.CourseRepository
import mu.KLogging
import org.springframework.stereotype.Service

@Service
class CourseService(val courseRepository: CourseRepository) {

    companion object : KLogging()
    
    fun addCourse(courseDTO: CourseDTO) {

        val courseEntity = courseDTO.let {
            Course(null, it.name, it.category)
        }

        courseRepository.save(courseEntity)

        logger.info("Saved course is $courseEntity")

        return courseEntity.let {
            CourseDTO(it.id, it.name, it.category)
        }
    }
    
}