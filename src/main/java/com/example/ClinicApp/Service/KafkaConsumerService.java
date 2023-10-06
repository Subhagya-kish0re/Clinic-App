package com.example.ClinicApp.Service;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaConsumerService {

    @KafkaListener(topics = "clinic-app", groupId = "my-group")
    public void consume(String message){
        System.out.println("Recieved Message "+message);
    }
}
