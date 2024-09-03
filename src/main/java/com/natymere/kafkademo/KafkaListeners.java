package com.natymere.kafkademo;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class KafkaListeners {

    @KafkaListener(topics = "natymere", groupId = "group1")
    public void listener(String data) {
        System.out.println("Listener received data: " + data + "\uD83E\uDD84");
    }
}
