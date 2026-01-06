package com.example.backend_test_project.entity;

import jakarta.persistence.*; // apparently this is not supported here should look into how to change it, this is for newer version
import java.time.LocalDateTime;

@Entity
@Table(name = "sensor_readings")
public class SensorReading {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String deviceId;
    private String sensorType;
    private double value;
    private LocalDateTime timestamp = LocalDateTime.now();

    // getters and setters
    public Long getId() { return id; }
    public void setId() { this.id = id; }
    public String getDeviceId() { return deviceId; }
    public void setDeviceId(String deviceId) { this.deviceId = deviceId; }
    public String getSensorType() { return sensorType; }
    public void setSensorType(String sensorType) { this.sensorType = sensorType; }
    public double getValue() { return value; }
    public void setValue(double value) { this.value = value; }
    public LocalDateTime getTimestamp() { return timestamp; }
    public void setTimestamp(LocalDateTime timestamp) { this.timestamp = timestamp; }
}
