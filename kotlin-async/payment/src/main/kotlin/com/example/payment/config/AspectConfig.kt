package com.example.payment.config

import org.aspectj.lang.ProceedingJoinPoint
import org.aspectj.lang.annotation.Around
import org.aspectj.lang.annotation.Aspect
import org.aspectj.lang.reflect.MethodSignature
import org.springframework.core.KotlinDetector
import org.springframework.stereotype.Component
import kotlin.coroutines.Continuation

@Aspect
@Component
class AspectConfig {

    @Around("""
        @annotation(org.springframework.web.bind.annotation.RequestMapping) ||
        @annotation(org.springframework.web.bind.annotation.PostMapping)    ||
        @annotation(org.springframework.web.bind.annotation.GetMapping)     ||
        @annotation(org.springframework.web.bind.annotation.PutMapping)     ||
        @annotation(org.springframework.web.bind.annotation.PatchMapping)   ||
        @annotation(org.springframework.web.bind.annotation.DeleteMapping)
    """)
    fun bindMdcToCoroutineContext(joinPoint: ProceedingJoinPoint): Any? {
        return if( isSuspendFunction(joinPoint) ) {
            val continuation = joinPoint.args.last() as Continuation<*>
            val newContext = continuation.context.plus(MDCContext())
            val newContinuation = Continuation(newContext) { continuation.resumeWith(it) }
            val newArgs = joinPoint.args.dropLast(1).plus(newContinuation)
            joinPoint.proceed(newArgs.toTypedArray())
        } else {
            joinPoint.proceed()
        }
    }

    private fun isSuspendFunction(joinPoint: ProceedingJoinPoint): Boolean {
        val method = (joinPoint.signature as MethodSignature).method
        return KotlinDetector.isSuspendingFunction(method)
    }

}
