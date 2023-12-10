package com.example.DeliveryBoy.Service;

import com.example.DeliveryBoy.Config.AppConstant;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class KalfkaService {

    private final KafkaTemplate<String,String> kafkaTemplate;

    private Logger logger=  LoggerFactory.getLogger(KalfkaService.class);
    @Autowired

    public KalfkaService(KafkaTemplate<String, String> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public boolean updateLocation(String location)
    {
        this.kafkaTemplate.send(AppConstant.TopicName,location);
        this.logger.info("Message Prodice");
        return true;
    }
}
