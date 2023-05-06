package com.example.kotlinreactive.requests

import javax.validation.constraints.Email
import javax.validation.constraints.NotEmpty

class UserCreateRequest(
    @field:NotEmpty
    var firstName: String,

    @field:NotEmpty
    var lastName: String,

    @field:Email
    var email: String
)