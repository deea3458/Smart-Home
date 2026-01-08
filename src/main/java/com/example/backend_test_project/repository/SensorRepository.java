package com.example.backend_test_project.repository;

import com.example.backend_test_project.entity.SensorReading;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SensorRepository extends JpaRepository<SensorReading, Long> {

    List<SensorReading> findTop10ByOrderByTimestampDesc();

    //finds all readings for a specific device
    List<SensorReading> findByDeviceId(String deviceId, Pageable pageable);

}