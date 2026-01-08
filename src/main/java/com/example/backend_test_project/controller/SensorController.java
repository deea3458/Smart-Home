package com.example.backend_test_project.controller;

import com.example.backend_test_project.entity.SensorReading;
import com.example.backend_test_project.repository.SensorRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.data.domain.PageRequest;

import java.util.List;

@RestController
@RequestMapping("/api/sensors")
public class SensorController {

    private final SensorRepository sensorRepository;

    public SensorController(SensorRepository sensorRepository) { this.sensorRepository = sensorRepository; }

    @PostMapping("/readings")
    public ResponseEntity<Void> receiveReading(@RequestBody SensorReading dto) {

        sensorRepository.save(dto);

        /*System.out.println("Received data:");
        System.out.println("Device: " + dto.getDeviceId());
        System.out.println("Sensor: " + dto.getSensorType());
        System.out.println("Value: " + dto.getValue() + " " + dto.getUnit());*/

        System.out.println("Saved data for device: " + dto.getDeviceId());

        return ResponseEntity.ok().build();
    }

    @GetMapping("/{deviceId}/readings")
    public List<SensorReading> getDeviceReadings(
            @PathVariable String deviceId,
            @RequestParam(defaultValue = "50") int limit) {

        return sensorRepository.findByDeviceId(deviceId, PageRequest.of(0, limit));
    }

    @GetMapping("/recent")
    public List<SensorReading> getRecentReadings() {
        return sensorRepository.findTop10ByOrderByTimestampDesc();
    }

}
