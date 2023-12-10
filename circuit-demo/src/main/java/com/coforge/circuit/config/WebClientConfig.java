package com.coforge.circuit.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
@ConfigurationProperties("rest")
@Setter
@Getter
public class WebClientConfig {

    private String employeeUrl;

    @Bean
    public WebClient webClient() {
        return WebClient.builder()
                .build();
    }
}
