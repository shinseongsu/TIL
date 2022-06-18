package com.kotlinspring.kotlinspringboot.service

import com.kotlinspring.kotlinspringboot.dto.CourseDTO
import com.kotlinspring.kotlinspringboot.entity.Course
import com.kotlinspring.kotlinspringboot.exception.CourseNotFoundException
import com.kotlinspring.kotlinspringboot.repository.CourseRepository
import mu.KLogging
import org.springframework.stereotype.Service

@Service
class CourseService(val courseRepository: CourseRepository) {

    companion object : KLogging()
    
    fun addCourse(courseDTO: CourseDTO): CourseDTO {

        val courseEntity = courseDTO.let {
            Course(null, it.name, it.category)
        }

        courseRepository.save(courseEntity)

        logger.info("Saved course is $courseEntity")

        return courseEntity.let {
            CourseDTO(it.id, it.name, it.category)
        }
    }

    fun retrieveAllCourse(): List<CourseDTO> {

        return courseRepository.findAll()
            .map {
                CourseDTO(it.id, it.name, it.category)
            }

    }

    fun updateCourrse(courseId: Int, courseDTO: CourseDTO): CourseDTO {

        val existingCourse = courseRepository.findById(courseId)

        return if(existingCourse.isPresent) {
            existingCourse.get()
                .let {
                    it.name = courseDTO.name
                    it.category = courseDTO.category
                    courseRepository.save(it)
                    CourseDTO(it.id, it.name, it.category)
                }
        } else {
            throw CourseNotFoundException("No course found for the passed in Id : $courseId")
        }

    }

}