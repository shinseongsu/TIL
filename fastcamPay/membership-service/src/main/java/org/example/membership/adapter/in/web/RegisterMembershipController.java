package org.example.membership.adapter.in.web;

import lombok.RequiredArgsConstructor;
import org.example.membership.application.port.in.RegisterMembershipCommand;
import org.example.membership.application.port.in.RegisterMembershipUseCase;
import org.example.membership.common.WebAdapter;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@WebAdapter
@RestController
@RequiredArgsConstructor
public class RegisterMembershipController {

    private final RegisterMembershipUseCase registerMembershipUseCase;

    @PostMapping("/membership/register")
    void registerMembership(@RequestBody RegisterMembershipRequest request) {
        RegisterMembershipCommand command = RegisterMembershipCommand.builder()
                .name(request.getName())
                .address(request.getAddress())
                .email(request.getEmail())
                .isValid(true)
                .isCorp(request.isCorp())
                .build();

        registerMembershipUseCase.registerMembership(command);
    }
}
