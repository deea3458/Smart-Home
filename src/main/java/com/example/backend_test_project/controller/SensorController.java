package com.example.backend_test_project.controller;

import com.example.backend_test_project.entity.SensorReading;
import com.example.backend_test_project.service.SensorService;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/sensors")
public class SensorController {

    private final SensorService sensorService;

    public SensorController(SensorService sensorService) {

        this.sensorService = sensorService;

    }

    @PostMapping("/readings")
    public ResponseEntity<Void> receiveReading(@RequestBody SensorReading reading) {


        sensorService.saveReading(reading);

        return ResponseEntity.ok().build();

    }

    @GetMapping("/{deviceId}/readings")
    public List<SensorReading> getDeviceReadings(@PathVariable String deviceId, @RequestParam(defaultValue = "50") int limit) {

        return sensorService.getDeviceReadings(deviceId, limit);

    }

    @GetMapping("/recent")
    public List<SensorReading> getRecentReadings() {

        return sensorService.getRecentReadings();

    }

}
