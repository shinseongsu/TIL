package com.microservice.kafka;

import com.microservice.kafka.runner.StreamRunner;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@Slf4j
@RequiredArgsConstructor
public class KafkaServiceApplication implements CommandLineRunner {

    private final StreamRunner streamRunner;

    public static void main(String[] args) {
        SpringApplication.run(KafkaServiceApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println("App start...");
        log.info("App start....");
        streamRunner.start();
    }
}
