package com.wipro.kafkasubscribe.config;

import java.util.HashMap;
import java.util.Map;

import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;
import org.springframework.kafka.support.serializer.JsonDeserializer;

import com.wipro.kafkasubscribe.model.Product;

@Configuration
@EnableKafka
public class KafkaConsumerConfig {
	
	@Bean
	public ConsumerFactory<String, String> consumerFactory(){
		Map<String, Object> configs = new HashMap<String,Object>();
		configs.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");
		configs.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
		configs.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
		configs.put(ConsumerConfig.GROUP_ID_CONFIG, "javateche-0");
		return new DefaultKafkaConsumerFactory<String, String>(configs);
	}
	
	@Bean
	public ConcurrentKafkaListenerContainerFactory<String, String> kafkaListenerContainerFactory(){
		ConcurrentKafkaListenerContainerFactory<String, String> factory = new ConcurrentKafkaListenerContainerFactory<>();
		factory.setConsumerFactory(consumerFactory());
		return factory;
	}

	@Bean
	public ConsumerFactory<String, Product> productConsumerFactory(){
		Map<String, Object> configs = new HashMap<String,Object>();
		configs.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");
		configs.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
		configs.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, JsonDeserializer.class);
		configs.put(ConsumerConfig.GROUP_ID_CONFIG, "javateche-1");
		//configs.put(JsonDeserializer.TRUSTED_PACKAGES, "*");
		return new DefaultKafkaConsumerFactory<>(configs,new StringDeserializer(),new JsonDeserializer<>(Product.class));
	}
	
	@Bean
	public ConcurrentKafkaListenerContainerFactory<String, Product> productKafkaListenerContainerFactory(){
		ConcurrentKafkaListenerContainerFactory<String, Product> factory = new ConcurrentKafkaListenerContainerFactory<String, Product>();
		factory.setConsumerFactory(productConsumerFactory());
		return factory;
	}
}
