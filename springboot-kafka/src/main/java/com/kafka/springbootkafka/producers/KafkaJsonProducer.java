package com.kafka.springbootkafka.producers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

import com.kafka.springbootkafka.payload.User;

@Service
public class KafkaJsonProducer {

	public static Logger logger = LoggerFactory.getLogger(KafkaJsonProducer.class);
	
	public KafkaTemplate<String, User> kafkaTemplate;

	public KafkaJsonProducer(KafkaTemplate<String, User> kafkaTemplate) {
		super();
		this.kafkaTemplate = kafkaTemplate;
	}
	
	public void send(User data) {
		
		logger.info("sending data: "+data);
		Message<User> message = MessageBuilder.withPayload(data).
				setHeader(KafkaHeaders.TOPIC,"kafkaJsonTopic1").build();
		logger.info("message: "+message);
		kafkaTemplate.send(message);
	}
	
}
