package com.kafka.springbootkafka.consumers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import com.kafka.springbootkafka.payload.User;

@Service
public class KafkaConsumerJson {
	
	private static Logger logger = LoggerFactory.getLogger(KafkaConsumerJson.class);
	
	@KafkaListener(topics = "kafkaJsonTopic1", groupId = "myGroup1")
	public void consumer(User user) {
		logger.info("Json Object consumed: User: "+user.toString());
		
	}


}
