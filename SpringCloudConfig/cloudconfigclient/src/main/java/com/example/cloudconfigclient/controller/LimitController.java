package com.example.cloudconfigclient.controller;

import com.example.cloudconfigclient.config.CloudConfigurationReader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/limits")
public class LimitController {

    @Autowired
    private CloudConfigurationReader configuration;

    @GetMapping("/getlimits")
    public CloudConfigurationReader getLimits(){
        return configuration;
    }
}
