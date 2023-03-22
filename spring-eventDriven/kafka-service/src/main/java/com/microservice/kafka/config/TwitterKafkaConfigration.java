package com.microservice.kafka.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
@ConfigurationProperties(prefix = "kafka-service")
@Getter
@Setter
public class TwitterKafkaConfigration {
    private List<String> twitterKeywords;
}
