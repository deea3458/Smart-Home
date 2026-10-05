package com.example.backend_test_project.service;

import com.example.backend_test_project.entity.SensorReading;
import com.example.backend_test_project.repository.DeviceRepository;
import com.example.backend_test_project.repository.SensorRepository;
import jakarta.transaction.Transactional;
import org.jspecify.annotations.Nullable;
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

    //Should later add exceptions for null values
    public @Nullable Double getLatestDeviceTemperature(String deviceId) {

        double lastTemperature = 0;

        List<SensorReading> lastFiveTemp= sensorRepository.getTop5SensorReadingByDeviceUIdAndSensorTypeOrderByTimestampDesc(deviceId, "temperature");

        for(SensorReading reading:lastFiveTemp) {

            lastTemperature += reading.getValue();

        }

        return lastTemperature / 5;
    }

    public @Nullable Double getLatestDeviceHumidity(String deviceId) {

        double lastHumidity = 0;

        List<SensorReading> lastFiveTemp= sensorRepository.getTop5SensorReadingByDeviceUIdAndSensorTypeOrderByTimestampDesc(deviceId, "humidity");

        for(SensorReading reading:lastFiveTemp) {

            lastHumidity += reading.getValue();

        }

        return lastHumidity / 5;
    }
}
