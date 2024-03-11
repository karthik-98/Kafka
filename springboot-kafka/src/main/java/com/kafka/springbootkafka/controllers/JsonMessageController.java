package com.kafka.springbootkafka.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kafka.springbootkafka.payload.User;
import com.kafka.springbootkafka.producers.KafkaJsonProducer;
import com.kafka.springbootkafka.producers.KafkaProducer;

@RestController
@RequestMapping("api/v1/kafka")
public class JsonMessageController {
	private static final Logger logger = LoggerFactory.getLogger(JsonMessageController.class);

	
	@Autowired
	private KafkaJsonProducer kafkaJsonProducer;

	public JsonMessageController(KafkaJsonProducer kafkaJsonProducer) {
		this.kafkaJsonProducer = kafkaJsonProducer;
	}
	
	@PostMapping("/publish/json")
	public ResponseEntity<String> publish(@RequestBody User user) {
		logger.info("the Messge to be sent: "+user.toString());
		kafkaJsonProducer.send(user);
		return ResponseEntity.ok("Json Message sent to topic: kafkaJsonTopic1");
	}
	


}
