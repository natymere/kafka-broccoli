package com.natymere.kafkademo;

import com.natymere.kafkademo.model.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("api/v1/messages")
public class MessageController {

    @Autowired
    KafkaTemplate<String, String> kafkaTemplate;

    @PostMapping("/message")
    public ResponseEntity<Message> createMessage(@RequestBody Message message) {
        kafkaTemplate.send("natymere", message.value);
        return ResponseEntity.ok(message);
    }
}
