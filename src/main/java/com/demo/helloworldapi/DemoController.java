package com.demo.helloworldapi;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class DemoController {

    @GetMapping("/status")
    public ResponseEntity<Map<String, String>> getStatus() {
        Map<String, String> response = new HashMap<>();
        response.put("status", "UP");
        response.put("role", "Harsha is a Developer");

        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PostMapping("/echo")
    public ResponseEntity<Map<String, Object>> echoPayload(@RequestBody Map<String, Object> payload) {
        Map<String, Object> response = new HashMap<>();
        response.put("message", "Payload received successfully");
        response.put("data", payload);

        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }
}