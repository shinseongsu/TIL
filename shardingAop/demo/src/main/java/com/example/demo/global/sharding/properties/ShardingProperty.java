package com.example.demo.global.sharding.properties;

import com.example.demo.global.sharding.constant.ShardingStrategy;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ShardingProperty {

    private ShardingStrategy strategy;
    private List<ShardingRule> rules;
    private int mod;

    @Getter
    @Setter
    @AllArgsConstructor
    @NoArgsConstructor
    public static class ShardingRule {
        private int sharNo;
        private Long rangeMin;
        private Long rangeMax;
    }

}
