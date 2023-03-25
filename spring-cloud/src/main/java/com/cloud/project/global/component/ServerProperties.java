package com.cloud.project.global.component;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@ConfigurationProperties(prefix = "my")
@Data
public class ServerProperties {

    private List<String> servers = new ArrayList<>();

}
