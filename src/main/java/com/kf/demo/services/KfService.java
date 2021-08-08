package com.kf.demo.services;

import java.util.List;

import com.kf.demo.dto.Profile;
import com.kf.demo.dto.ProfileList;
import com.kf.demo.dto.User;

import org.apache.kafka.clients.ClientResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.WebClientResponseException;
import org.springframework.web.reactive.function.client.WebClient.ResponseSpec;

import reactor.core.publisher.Mono;

@Service
public class KfService {

    private final static String TOPIC = "kafkaPOC";
    private final static String TOPIC_JSON = "kafkaJSON";

    @Value("${bot.URL}")
    private String botApiUrl;

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

    public void produceBumble() {
        System.out.println(this.botApiUrl);
        WebClient.builder().baseUrl("https://jsonplaceholder.typicode.com").build().get().uri("/todos/1").retrieve().bodyToMono(ProfileList.class);

    }


}
