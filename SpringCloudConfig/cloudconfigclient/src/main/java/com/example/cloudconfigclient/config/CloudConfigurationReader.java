package com.example.cloudconfigclient.config;


import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;


@Component
@Data
@ConfigurationProperties("limits-service")
public class CloudConfigurationReader {

    int minimum;
    int maximum;


}
