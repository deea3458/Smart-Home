package com.example.backend_test_project.repository;

import com.example.backend_test_project.entity.SensorReading;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SensorRepository extends JpaRepository<SensorReading, Long> {
}