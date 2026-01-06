package com.example.backend_test_project.controller;

import com.example.backend_test_project.entity.SensorReading;
import com.example.backend_test_project.repository.SensorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/sensors")
public class SensorController {

    @Autowired
    private SensorRepository sensorRepository;

    public SensorController(SensorRepository sensorRepository) { this.sensorRepository = sensorRepository; }

    @PostMapping("/readings")
    public ResponseEntity<Void> receiveReading(@RequestBody SensorReading dto) {

        sensorRepository.save(dto);

        /*System.out.println("Received data:");
        System.out.println("Device: " + dto.getDeviceId());
        System.out.println("Sensor: " + dto.getSensorType());
        System.out.println("Value: " + dto.getValue() + " " + dto.getUnit());*/

        System.out.println("Saved data for Device: " + dto.getDeviceId());

        return ResponseEntity.ok().build();
    }
}
