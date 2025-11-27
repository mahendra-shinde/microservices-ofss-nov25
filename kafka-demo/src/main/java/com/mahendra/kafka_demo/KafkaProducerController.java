package com.mahendra.kafka_demo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/kafka")
public class KafkaProducerController {

	private final KafkaTemplate<String, String> kafkaTemplate;
	private final String topic;
	
	public KafkaProducerController(KafkaTemplate<String, String> kafkaTemplate, 
			@Value("${kafka.topic.demo}")
			String topic) {
		this.kafkaTemplate = kafkaTemplate;
		this.topic = topic;
	}
	
	
	@PostMapping("/send")
	public String sendMessage(@RequestBody String message) {
		kafkaTemplate.send(topic, message);
		return "Message send to "+topic;
	}
	
}
