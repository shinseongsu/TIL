package com.zerobase.api.test

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/fintech/api/v1")
class TestController(
    private val testService: TestService
) {

    @GetMapping("/test/get/{userKey}")
    fun Test(
        @PathVariable userKey: String
    ): TestDto.UserInfoDto = testService.testGetService(userKey)

}