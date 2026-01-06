package com.example.backend_test_project.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/api/actuators")
public class ActuatorController {

    private static final String ESP32_ADDRESS = "http://192.168.43.216";

    @GetMapping("/led")
    public ResponseEntity<String> controlLed(@RequestParam String state) {

        // 1. Validate the command
        if (!state.equals("on") && !state.equals("off") && !state.equals("reset")) {
            return ResponseEntity.badRequest().body("Invalid command! Use 'on', 'off', or 'reset'.");
        }

        // 2. Prepare the URL
        String url = ESP32_ADDRESS + "/led?state=" + state;

        // 3. Send the command to ESP32
        RestTemplate restTemplate = new RestTemplate();
        try {
            // This acts like a browser hitting the ESP32's web server
            String response = restTemplate.getForObject(url, String.class);

            // 4. Return the ESP32's reply to the user
            return ResponseEntity.ok("Command sent to ESP32. Response: " + response);

        } catch (Exception e) {
            return ResponseEntity.internalServerError()
                    .body("Error: Could not reach ESP32 at " + ESP32_ADDRESS + ". Is it connected?");
        }
    }
}