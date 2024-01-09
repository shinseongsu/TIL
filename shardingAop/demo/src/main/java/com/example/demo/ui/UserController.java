package com.example.demo.ui;

import com.example.demo.application.UserService;
import com.example.demo.domain.Users;
import com.example.demo.ui.dto.UserRequest;
import com.example.demo.ui.dto.UserResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping("/users")
    public ResponseEntity<UserResponse> save(@RequestBody UserRequest request) {
        Users user = userService.save(request.name());

        return ResponseEntity.ok(
                new UserResponse(user.getId(), user.getName())
        );
    }

}
