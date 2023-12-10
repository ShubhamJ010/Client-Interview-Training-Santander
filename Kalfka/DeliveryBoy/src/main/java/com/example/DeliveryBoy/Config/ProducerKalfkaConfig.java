package com.example.DeliveryBoy.Config;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

@Configuration
public class ProducerKalfkaConfig {

    @Bean
    public NewTopic newTopic()
    {
        return  TopicBuilder
                .name(AppConstant.TopicName)
//                .partitions()
//                .replicas()
                .build();
    }
}
