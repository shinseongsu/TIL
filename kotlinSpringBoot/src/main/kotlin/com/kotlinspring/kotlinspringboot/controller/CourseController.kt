package com.kotlinspring.kotlinspringboot.controller

import com.kotlinspring.kotlinspringboot.dto.CourseDTO
import com.kotlinspring.kotlinspringboot.service.CourseService
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("v1/courses")
class CourseController(val courseService: CourseService) {

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    fun addCourse(@RequestBody courseDTO: CourseDTO) {
        return courseService.addCourse(courseDTO)
    }

}