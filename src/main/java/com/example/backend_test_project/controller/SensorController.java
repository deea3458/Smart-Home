package com.example.backend_test_project.controller;

import com.example.backend_test_project.entity.SensorReading;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/sensors")
public class SensorController {

    @PostMapping("/readings")
    public void receiveReading(@RequestBody SensorReading dto) {
        System.out.println("Received data:");
        System.out.println("Device: " + dto.getDeviceId());
        System.out.println("Sensor: " + dto.getSensorType());
        System.out.println("Value: " + dto.getValue()); // + " " + dto.getUnit());
    }
}
