package com.example.ClinicApp.Controller;

import com.example.ClinicApp.Service.KafkaProducerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/kafka")
public class KafkaController {
    @Autowired
    private KafkaProducerService kafkaProducerService;

    @PostMapping("/send")
    public ResponseEntity<String> sendMessage(@RequestParam String message){
        if(message.isBlank()){
           return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("The message is Blank");
        }else {
            kafkaProducerService.sendMessage( message);
            return ResponseEntity.ok("Message sent Succesfully");
        }
    }
}
