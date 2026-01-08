package com.example.backend_test_project.service.handlers;

import com.example.backend_test_project.entity.ActuatorCommand;
import com.example.backend_test_project.service.ActuatorHandler;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class DisplayHandler implements ActuatorHandler {
    @Override
    public String getActuatorType() {
        return "display";
    }

    @Override
    public void handle(ActuatorCommand command) throws Exception {
        // Use the IP you found earlier for the ESP32
        String url = "http://192.168.43.216/display?text=" + command.getValue().toLowerCase();
        new RestTemplate().getForObject(url, String.class);
    }
}