package com.kf.demo.configuration;


import java.util.HashMap;
import java.util.Map;

import com.kf.demo.dto.Profile;
import com.kf.demo.dto.User;

import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;
import org.springframework.kafka.support.serializer.JsonSerializer;


@Configuration
public class ProducerConfiguration {

	
	@Bean
	public ProducerFactory<String, Profile> profileProducerFactory() {

		Map<String, Object> config = new HashMap<String, Object>();

		config.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:29092"); // docker-compose confluentinc/cp-kafka:latest
		config.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
		config.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, JsonSerializer.class);
		return new DefaultKafkaProducerFactory<String, Profile>(config);
	}

	@Bean
	public KafkaTemplate<String, Profile> kafkaTemplateProfile() {
		return new KafkaTemplate<String, Profile>(profileProducerFactory());
	}


	@Bean
	public ProducerFactory<String, User> jsonProducerFactory() {

		Map<String, Object> config = new HashMap<String, Object>();

		config.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:29092"); // docker-compose confluentinc/cp-kafka:latest
		config.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
		config.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, JsonSerializer.class);
		return new DefaultKafkaProducerFactory<String, User>(config);
	}

	@Bean
	public KafkaTemplate<String, User> kafkaJsonTemplate() {
		return new KafkaTemplate<String, User>(jsonProducerFactory());
	}

	@Bean
	public ProducerFactory<String, String> producerFactory() {

		Map<String, Object> config = new HashMap<String, Object>();

		config.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:29092");
		config.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
		config.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
		return new DefaultKafkaProducerFactory<String, String>(config);
	}

	@Bean
	public KafkaTemplate<String, String> kafkaTemplate() {
		return new KafkaTemplate<String, String>(producerFactory());
	}
}