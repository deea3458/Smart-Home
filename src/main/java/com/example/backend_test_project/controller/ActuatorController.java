package com.example.backend_test_project.controller;

import com.example.backend_test_project.entity.ActuatorCommand;
import com.example.backend_test_project.service.ActuatorService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/actuators")
public class ActuatorController {

    private final ActuatorService actuatorService;

    public ActuatorController(ActuatorService actuatorService) {
        this.actuatorService = actuatorService;
    }

    @PostMapping("/{deviceId}/commands")
    public ResponseEntity<String> sendCommand(
            @PathVariable String deviceId,
            @RequestBody ActuatorCommand command) {

        command.setDeviceId(deviceId);

        try {
            actuatorService.processCommand(command);
            return ResponseEntity.ok("Command processed for " + command.getActuator());
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body("Hardware error: " + e.getMessage());
        }
    }
}