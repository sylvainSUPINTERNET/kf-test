package com.kf.demo.controllers;

import com.google.gson.Gson;
import com.kf.demo.dto.User;
import com.kf.demo.services.KfService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class KfController {
    
    @Autowired
    KfService kfService;

    public KfController(){}


    @PostMapping("/{name}")
    public ResponseEntity<?> publishMsg(@PathVariable(name="name") String name) {
        this.kfService.sendMsg(name);
        return ResponseEntity.status(HttpStatus.OK).body("Published with success");
    };

    @KafkaListener(topics = "kafkaJSON", groupId = "group_id_json")
    public void consumeJsonKf (String message) {
        Gson gson = new Gson();
        User user = gson.fromJson(message, User.class);
        System.out.println("CONSUME " + user.getFirstName());
    }
}
