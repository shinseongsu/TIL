package com.example.demo.application;

import com.example.demo.domain.Users;
import com.example.demo.domain.UsersRepository;
import com.example.demo.global.sharding.annotation.Sharding;
import com.example.demo.global.sharding.annotation.ShardingKey;
import com.example.demo.global.sharding.constant.ShardingTarget;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class UserAdapter {

    private final UsersRepository usersRepository;

    @Sharding(target = ShardingTarget.NAME)
    public Users save(@ShardingKey long shardingKey, Users users) {
        log.info(shardingKey + "");
        return usersRepository.save(users);
    }

}
