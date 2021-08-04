package com.kf.demo.services;

import com.kf.demo.dto.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class KfService {

    private final static String TOPIC = "kafkaPOC";
    private final static String TOPIC_JSON = "kafkaJSON";

    @Autowired
    KafkaTemplate<String, User> kafkaTemplateJson;

    @Autowired
    KafkaTemplate<String, String> kafkaTemplate2;

    public KfService(){}

    public void sendMsg(String name) {
        User user = new User();
        user.setFirstName(name);
        this.kafkaTemplateJson.send(TOPIC_JSON, user);
    }


}
