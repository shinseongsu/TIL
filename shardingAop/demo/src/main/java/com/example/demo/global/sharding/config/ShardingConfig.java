package com.example.demo.global.sharding.config;

import com.example.demo.global.sharding.constant.ShardingTarget;
import com.example.demo.global.sharding.properties.ShardingProperty;
import lombok.Setter;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Setter
public class ShardingConfig {

    private static Map<ShardingTarget, ShardingProperty> shardingPropertyMap = new ConcurrentHashMap<>();

    public static Map<ShardingTarget, ShardingProperty> getShardingPropertyMap() {
        return shardingPropertyMap;
    }

}
