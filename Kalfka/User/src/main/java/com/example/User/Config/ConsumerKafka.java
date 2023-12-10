package com.example.User.Config;

import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.KafkaListener;

@Configuration
public class ConsumerKafka {

    @KafkaListener(topics = "location-update-topic" ,groupId = "group-1")
    public void updatelocation(String update)
    {
        System.out.println(update);
    }
}
