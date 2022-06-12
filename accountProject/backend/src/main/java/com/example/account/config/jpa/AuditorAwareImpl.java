package com.example.account.config.jpa;

import com.example.account.constatnt.Constant;
import org.springframework.data.domain.AuditorAware;

import java.util.Optional;

public class AuditorAwareImpl implements AuditorAware<String> {

    @Override
    public Optional<String> getCurrentAuditor() {
        return Optional.of(Constant.SYSTEM.getValue());
    }
}
