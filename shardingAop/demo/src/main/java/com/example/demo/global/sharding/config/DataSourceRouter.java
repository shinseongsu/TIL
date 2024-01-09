package com.example.demo.global.sharding.config;

import com.example.demo.global.sharding.constant.ShardingStrategy;
import com.example.demo.global.sharding.error.InvalidShardKeyException;
import com.example.demo.global.sharding.error.ShardingStrategyNotFoundException;
import com.example.demo.global.sharding.properties.ShardingProperty;
import com.example.demo.global.sharding.properties.ShardingProperty.ShardingRule;
import com.example.demo.global.sharding.threadlocal.ThreadLocalContext;
import com.example.demo.global.sharding.threadlocal.ThreadLocalContext.Sharding;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;
import org.springframework.transaction.support.TransactionSynchronizationManager;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
public class DataSourceRouter extends AbstractRoutingDataSource {

    private static final String MASTER = "master";
    private static final String SLAVE = "slave";
    private static final String SHARD_DELIMITER = "|";

    private Map<Integer, MhaDataSource> shards;

    @Override
    public void setTargetDataSources(Map<Object, Object> targetDataSources) {
        super.setTargetDataSources(targetDataSources);

        shards = new HashMap<>();

        for(Object item: targetDataSources.keySet()) {
            String dataSourceName = item.toString();
            String shardNoStr = dataSourceName.split(SHARD_DELIMITER)[0];

            MhaDataSource shard = getShard(shardNoStr);
            if(dataSourceName.contains(MASTER)) {
                shard.setMasterName(dataSourceName);
            } else {
                shard.setSlaveName(dataSourceName);
            }
        }
    }

    @Override
    protected Object determineCurrentLookupKey() {
        Sharding sharding = ThreadLocalContext.getSharding();
        int shardNo = getShardNo(sharding);
        MhaDataSource dataSource = shards.get(shardNo);
        return TransactionSynchronizationManager.isCurrentTransactionReadOnly() ?
                dataSource.getSlaveName() :
                dataSource.getMasterName();
    }

    private int getShardNo(Sharding sharding) {
        if(sharding == null) {
            return 0;
        }

        if(sharding.getSharNo() != null) {
            return sharding.getSharNo();
        }

        ShardingProperty shardingProperty = ShardingConfig.getShardingPropertyMap()
                .get(sharding.getTarget());
        if(shardingProperty.getStrategy() == ShardingStrategy.RANGE) {
            return getShardNoByRange(shardingProperty.getRules(), sharding.getShardKey());
        }
        if(shardingProperty.getStrategy() == ShardingStrategy.MODULAR) {
            return getShardNoByModular(shardingProperty.getMod(), sharding.getShardKey());
        }

        throw new ShardingStrategyNotFoundException();
    }

    private int getShardNoByModular(int modulus, long shardKey) { // [11]
        return (int) (shardKey % modulus);
    }

    private int getShardNoByRange(List<ShardingRule> rules, long shardKey) {
        for(ShardingRule rule : rules) {
            if(rule.getRangeMin() <= shardKey && shardKey <= rule.getRangeMax()) {
                return rule.getSharNo();
            }
        }
        throw new InvalidShardKeyException();
    }

    private MhaDataSource getShard(String shardNoStr) {
        int shardNo = 0;
        if(isNumeric(shardNoStr)) {
            shardNo = Integer.valueOf(shardNoStr);
        }

        MhaDataSource shard = shards.get(shardNo);
        if(shard == null) {
            shard = new MhaDataSource();
            shards.put(shardNo, shard);
        }
        return shard;
    }

    public int getShardSize() {
        return shards.size();
    }

    private boolean isNumeric(String input) {
        try {
            Integer.parseInt(input);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    @Getter
    @Setter
    private class MhaDataSource {
        private String masterName;
        private String slaveName;
    }

}
