package com.example.demo.application;

import com.example.demo.domain.Users;
import com.example.demo.domain.UsersRepository;
import com.example.demo.global.sharding.annotation.Sharding;
import com.example.demo.global.sharding.annotation.ShardingKey;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Random;

@Service
@RequiredArgsConstructor
@Transactional
public class UserService {

    private final UserAdapter userAdapter;
    private final Random random = new Random();

    public Users save(final String name) {
        return userAdapter.save(random.nextInt(100), new Users(name));
    }

}
