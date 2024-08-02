package com.example.payment.config.validator

import jakarta.validation.Constraint
import jakarta.validation.ConstraintValidator
import jakarta.validation.ConstraintValidatorContext
import jakarta.validation.Payload
import kotlin.reflect.KClass

@Target(AnnotationTarget.FIELD)
@Retention(AnnotationRetention.RUNTIME)
@Constraint(validatedBy = [DateValidator::class])
annotation class DateString (
    val message: String = "not a valid date",
    val groups: Array<KClass<*>> = [],
    val payload: Array<KClass<out Payload>> = []
)

class DateValidator: ConstraintValidator<DateString, String> {
    override fun isValid(value: String?, context: ConstraintValidatorContext?): Boolean {
        val text = value?.filter { it.isDigit() } ?: return true
        return runCatching {
            text.toLocalDate().let {
                if(text != it.toString("yyyyMMdd")) null else true
            }
        }.getOrNull()
    }
}
