package com.wipro.kafkapublisher.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.wipro.kafkapublisher.model.Product;

@RestController
public class PublisherController {
	
	@Autowired
	private KafkaTemplate<String, Object> kafkaTemplate;
	

	private String topic = "javateche";
	
	//kafka-topics.bat --create --zookeeper localhost:2181 --replication-factor 1 --partitions 1 -topic javateche
	//kafka-console-consumer.bat --bootstrap-server localhost:9092 --topic javateche
	//default consumer port is 9092
	//zookeeper default port is 2181
	@GetMapping("/publish/{name}")
	public String publishMessage(@PathVariable String name) {
		kafkaTemplate.send(topic, "Hi "+name+" Welcome to Java Teche");
		return "Data Published";
	}
	
	@GetMapping("/publishJson")
	public String publishJsonMessage() {
		Product product = new Product(1234,"shapoo",new String[]{"123","anti dandroof"});
		//kafkaTemplate.send(topic, product);
		kafkaTemplate.send(topic, product);
		return "Json Data Published";
	}
}
