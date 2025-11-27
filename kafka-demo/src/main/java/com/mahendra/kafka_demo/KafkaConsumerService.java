package com.mahendra.kafka_demo;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaConsumerService {

		@KafkaListener(topics="${kafka.topic.demo}", groupId = "kafka-demo-group")
		public void listen(String message) {
			System.out.println("Received message from kafka: "+message);
		}
}
