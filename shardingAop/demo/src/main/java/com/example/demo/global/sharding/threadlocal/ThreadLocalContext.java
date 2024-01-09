package com.example.demo.global.sharding.threadlocal;

import com.example.demo.global.sharding.constant.ShardingTarget;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

public class ThreadLocalContext {

    private static final ThreadLocal<Context> THREAD_LOCAL = new ThreadLocal<>();

    public static Context getContext() {
        if(THREAD_LOCAL.get() == null) {
            Context context = new Context();
            context.setSharding(null);
            THREAD_LOCAL.set(context);
            return THREAD_LOCAL.get();
        }
        return THREAD_LOCAL.get();
    }

    public static void setSharding(ShardingTarget target, long shardKey) {
        getContext().setSharding(new Sharding(target, shardKey));
    }

    public static void setShardingWithShardNo(int shardNo) {
        Sharding sharding = new Sharding();
        sharding.setSharNo(shardNo);
        getContext().setSharding(sharding);
    }

    public static void clearSharding() {
        getContext().setSharding(null);
    }

    public static Sharding getSharding() {
        return getContext().getSharding();
    }

    @Getter
    @Setter
    public static class Context {
        private Sharding sharding;
    }


    @Getter
    @Setter
    @NoArgsConstructor
    public static class Sharding {
        private ShardingTarget target;
        private long shardKey;
        private Integer sharNo;

        public Sharding(ShardingTarget target, long shardKey) {
            this.target = target;
            this.shardKey = shardKey;
        }
    }

}
