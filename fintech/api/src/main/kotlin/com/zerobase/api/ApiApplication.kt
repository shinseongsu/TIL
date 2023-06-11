package com.zerobase.api

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.autoconfigure.domain.EntityScan
import org.springframework.boot.runApplication
import org.springframework.context.annotation.ComponentScan

@SpringBootApplication
@EntityScan(basePackages = ["com.zerobase.domain"])
@ComponentScan(basePackages = ["com.zerobase"])
class ApiApplication

fun main(args: Array<String>) {
    runApplication<ApiApplication>(*args)
}