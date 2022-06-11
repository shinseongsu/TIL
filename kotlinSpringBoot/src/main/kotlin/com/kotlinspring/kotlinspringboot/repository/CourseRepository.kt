package com.kotlinspring.kotlinspringboot.repository

import com.kotlinspring.kotlinspringboot.entity.Course
import org.springframework.data.repository.CrudRepository

interface CourseRepository : CrudRepository<Course, Int> {
}