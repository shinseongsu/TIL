package com.example.demo.global.sharding.properties;

import com.example.demo.global.sharding.config.ShardingConfig;
import com.example.demo.global.sharding.constant.ShardingTarget;
import jakarta.annotation.PostConstruct;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix = "sharding")
@Setter
public class ShardingPropertiesConfig {

    private ShardingProperty name;

    @PostConstruct
    public void init() {
        ShardingConfig.getShardingPropertyMap()
                .put(ShardingTarget.NAME, name);
    }

}
