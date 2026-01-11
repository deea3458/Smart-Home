package com.example.backend_test_project.service;


import com.example.backend_test_project.dto.request.DeviceHelloRequest;
import com.example.backend_test_project.entity.Device;
import com.example.backend_test_project.entity.HomeAccount;
import com.example.backend_test_project.repository.DeviceRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class DeviceService {

    private final DeviceRepository deviceRepository;

    public DeviceService(DeviceRepository devices) {

        this.deviceRepository = devices;

    }

    //For authenticating device responses(?) to the server
    public Device authenticateDevice(String apiKey) {

        return deviceRepository.findByApiKey(apiKey).orElseThrow(() -> new SecurityException("Invalid device key!"));

    }

    public Device createNewDevice(DeviceHelloRequest request) {

        Device device = new Device();
        device.setDeviceUId(request.getDeviceUId());
        device.setDeviceType(request.getDeviceType());

        return device;

    }

    @Transactional
    public void registerDevice(DeviceHelloRequest request) {

        Device device = deviceRepository.findByDeviceUId(request.getDeviceUId()).orElseGet(() -> createNewDevice(request));

        device.setLastSeen(LocalDateTime.now());
        device.setInUse(true);

        deviceRepository.save(device);
    }

    @Transactional
    public Device findAndClaimable(String deviceUId) {

        Device device = deviceRepository.findByDeviceUId(deviceUId).orElseThrow(() -> new SecurityException("Device not found!"));

        if (device.getInUse() == true) {
            throw new IllegalStateException("Device already in use!");
        }

        if (device.getHousehold() != null) {
            throw new IllegalStateException("Device already assigned!");
        }

        return device;
    }

    //mai trebuie schimbat si sensorservice ca sa verifice cand primeste reading device ul e in use and authenticated(?)
    @Transactional
    public void assignDeviceToHousehold(String deviceId, HomeAccount household) {

        Device device = findAndClaimable(deviceId);

        device.setHousehold(household);
        device.setInUse(true);

    }
}