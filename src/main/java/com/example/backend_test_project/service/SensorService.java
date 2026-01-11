package com.example.backend_test_project.service;

import com.example.backend_test_project.entity.Device;
import com.example.backend_test_project.entity.SensorReading;
import com.example.backend_test_project.repository.DeviceRepository;
import com.example.backend_test_project.repository.SensorRepository;
import jakarta.transaction.Transactional;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SensorService {

    private final SensorRepository sensorRepository;
   // private final DeviceRepository deviceRepository;

    public SensorService(SensorRepository sensorRepository, DeviceRepository deviceRepository) {

        this.sensorRepository = sensorRepository;
        //this.deviceRepository = deviceRepository;
    }

    @Transactional
    public void saveReading(SensorReading reading) {

       // Device device = deviceRepository.findByDeviceUId(reading.getDeviceUId()).orElseThrow(() -> new IllegalArgumentException("Unknown device detected!"));
        //device.setLastSeen(reading.getTimestamp());

        sensorRepository.save(reading);
        System.out.println("Saved data for device: " + reading.getDeviceUId());

    }

    public List<SensorReading> getDeviceReadings(String deviceId, int limit) {

        return sensorRepository.findByDeviceUId(deviceId, PageRequest.of(0, limit));

    }

    public List<SensorReading> getRecentReadings() {

        return sensorRepository.findTop10ByOrderByTimestampDesc();

    }
}
