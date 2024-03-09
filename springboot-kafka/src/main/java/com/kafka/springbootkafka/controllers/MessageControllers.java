package com.kafka.springbootkafka.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.kafka.springbootkafka.producers.KafkaProducer;

@RestController
@RequestMapping("api/v1/kafka")
public class MessageControllers {

	private static final Logger logger = LoggerFactory.getLogger(MessageControllers.class);
	
	private KafkaProducer kafkaProducer;

	public MessageControllers(KafkaProducer kafkaProducer) {
		super();
		this.kafkaProducer = kafkaProducer;
	}
	
	//localhost:8081/api/v1/kafka/publish?message=customMessage
	@GetMapping("/publish")
	public ResponseEntity<String> publish(@RequestParam("message") String message) {
		logger.info("publish start: message: "+message);
		kafkaProducer.sendMessage(message);
		logger.info("publish end");
		return ResponseEntity.ok("Message published");
	}
	
	
}
