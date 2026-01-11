package com.example.backend_test_project.repository;

import com.example.backend_test_project.entity.Device;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface DeviceRepository extends JpaRepository<Device, Long> {

    Optional<Device> findByDeviceUId(String deviceUId);

    Optional<Device> findByApiKey(String apiKey);

    List<Device> findByHouseholdId(Long householdId);
}