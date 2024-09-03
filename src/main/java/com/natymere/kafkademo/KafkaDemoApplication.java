package com.natymere.kafkademo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.kafka.core.KafkaTemplate;

import java.time.LocalDateTime;

@SpringBootApplication
public class KafkaDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(KafkaDemoApplication.class, args);
	}

	@Bean
	CommandLineRunner commandLineRunner(KafkaTemplate<String, String> kafkaTemplate) {
		System.out.println("Running command line runner");
		return args -> {
			LocalDateTime previous = LocalDateTime.now();
			for (int i = 0; i < 100; i++) {
				LocalDateTime current = LocalDateTime.now();
				kafkaTemplate.send("natymere", i + ". hello natymere!");
				previous = current;
			}
		};
	}
}
