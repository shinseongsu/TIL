package com.example.demo.global.sharding.aop;

import com.example.demo.global.sharding.annotation.Sharding;
import com.example.demo.global.sharding.annotation.ShardingKey;
import com.example.demo.global.sharding.config.DataSourceRouter;
import com.example.demo.global.sharding.threadlocal.ThreadLocalContext;
import lombok.RequiredArgsConstructor;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
@RequiredArgsConstructor
public class ShardingAspect {

    private final DataSourceRouter dataSourceRouter;

    @Around("@annotation(sharding) && args(shardKey,..)")
    public Object handler(ProceedingJoinPoint joinPoint, Sharding sharding, long shardKey) throws Throwable {
        ThreadLocalContext.setSharding(sharding.target(), shardKey);
        Object returnVal = joinPoint.proceed();
        ThreadLocalContext.clearSharding();
        return returnVal;
    }

}
