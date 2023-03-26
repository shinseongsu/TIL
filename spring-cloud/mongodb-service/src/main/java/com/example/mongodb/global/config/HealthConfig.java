package com.example.mongodb.global.config;

import io.micrometer.core.instrument.Meter;
import io.micrometer.core.instrument.MeterRegistry;
import org.springframework.boot.actuate.autoconfigure.metrics.MeterRegistryCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class HealthConfig {

    @Bean
    public MeterRegistryCustomizer<MeterRegistry> addPersonRegistry() {
        return registry -> registry.config().namingConvention().name("services.person.add", Meter.Type.COUNTER);
    }

    @Bean
    public MeterRegistryCustomizer<MeterRegistry> deletePersonRegistry() {
        return registry -> registry.config().namingConvention().name("services.person.deleted", Meter.Type.COUNTER);
    }


}
