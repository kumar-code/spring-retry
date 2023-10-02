package com.example.demo.controller;

import com.example.demo.service.NetworkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @Autowired
    private NetworkService configureNetworkService;

    @GetMapping("/")
    public String index() {
        configureNetworkService.configureNetworkSystem();
        return "Greetings from Spring Boot!";
    }

}