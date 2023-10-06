package com.example.ClinicApp.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class KafkaProducerService {
    private final String topic = "clinic-app";
    @Autowired
    private KafkaTemplate<String,String>kafkaTemplate;

    public void sendMessage(String message){
        kafkaTemplate.send(topic,message);
    }


}
