package com.safaricom.configclient.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ConfigClientController {

    @Value("${message}")
    private String message;
    @Value("${user.role}")
    private String role;

    @GetMapping("/message")
    public String getMessage() {
        return message;
    }

    @GetMapping(value = "/whoami/{username}", produces = MediaType.TEXT_PLAIN_VALUE)
    public String whoami(@PathVariable("username") String username) {
        return String.format("Hello! You're %s and you'll become a(n) %s...\n", username, role);
    }

}
