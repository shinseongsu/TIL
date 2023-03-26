package com.example.client.ui;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@Slf4j
public class PingController {

    private final DiscoveryClient discoveryClient;

    @GetMapping("/ping")
    public List<ServiceInstance> ping() {
        List<ServiceInstance> instances = discoveryClient.getInstances("CLIENT-SERVICE");
        log.info("INSTANCES: count = {}", instances.size());
        instances.stream()
                .forEach(it -> log.info("INSTANCE: id = {}, port = {}", it.getServiceId(), it.getPort()));

        return instances;
    }

}
