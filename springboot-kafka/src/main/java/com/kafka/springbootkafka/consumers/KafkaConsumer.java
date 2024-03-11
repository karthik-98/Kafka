package com.kafka.springbootkafka.consumers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaConsumer {
	
	private static Logger logger = LoggerFactory.getLogger(KafkaConsumer.class);
	
	@KafkaListener(topics = "kafkaTopic1", groupId = "myGroup1")
	public void consume(String message) {
		logger.info("Message consumed: "+ message);
	}
	
//	@KafkaListener(topics = "kafkaTopic1", groupId = "myGroup1")
//	public void consume(String message) {
//		logger.info("Message consumed: "+ message);
//	}

}
