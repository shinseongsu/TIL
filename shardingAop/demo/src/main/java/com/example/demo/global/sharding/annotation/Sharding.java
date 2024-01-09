package com.example.demo.global.sharding.annotation;

import com.example.demo.global.sharding.constant.ShardingTarget;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface Sharding {
    ShardingTarget target();
}
