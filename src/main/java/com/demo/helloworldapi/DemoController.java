package com.demo.helloworldapi;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestHeader;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class DemoController {

    // Add the 'produces' parameter right here!
    @GetMapping(value = "/status", produces = "application/json")
    public String getStatus(@RequestHeader(value = "User-Agent", defaultValue = "Browser") String userAgent) {
        
        System.out.println("🟢 /api/status endpoint hit by: " + userAgent);
        
        return "{\"status\": \"UP\", \"role\": \"Developer\"}";
    }

    @PostMapping("/echo")
    public ResponseEntity<Map<String, Object>> echoPayload(@RequestBody Map<String, Object> payload) {
        Map<String, Object> response = new HashMap<>();
        response.put("message", "Payload received successfully");
        response.put("data", payload);

        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }
}
