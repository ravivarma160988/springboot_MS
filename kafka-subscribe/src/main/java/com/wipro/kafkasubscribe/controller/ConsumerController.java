package com.wipro.kafkasubscribe.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wipro.kafkasubscribe.model.Product;

@RestController
public class ConsumerController {
	
	List<String> messages = new  ArrayList<String>();
	
	Product productTopic = null;
	
	@GetMapping("/consumeStringMessage")
	public List<String> consumeMsg(){
		return messages;
	}
	
	@GetMapping("/consumeProductMessage")
	public Product consumeProductMsg(){
		return productTopic;
	}
	
	@KafkaListener(groupId="javateche-0",topics="javateche",containerFactory="kafkaListenerContainerFactory")
	public List<String> getMsgFromTopic(String data){
		messages.add(data);
		return messages;
	}
	
	@KafkaListener(groupId="javateche-1",topics="javateche",containerFactory="productKafkaListenerContainerFactory")
	public Product getJsonMsgFromTopic(Product product){
		productTopic= product;
		return productTopic;
	}

}
