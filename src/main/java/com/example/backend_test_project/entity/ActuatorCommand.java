package com.example.backend_test_project.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "actuator_commands")
public class ActuatorCommand {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "device_id")
    private String deviceId;

    private String actuator;

    @Column(name = "command_value")
    private double value;

    private boolean executed = false;

    private LocalDateTime timestamp = LocalDateTime.now();

    // Required blank constructor for JPA
    public ActuatorCommand() {}

    // Getters and setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getDeviceId() { return deviceId; }
    public void setDeviceId(String deviceId) { this.deviceId = deviceId; }

    public String getActuator() { return actuator; }
    public void setActuator(String actuator) { this.actuator = actuator; }

    public double getValue() { return value; }
    public void setValue(double value) { this.value = value; }

    public boolean isExecuted() { return executed; }
    public void setExecuted(boolean executed) { this.executed = executed; }

    public LocalDateTime getTimestamp() { return timestamp; }
    public void setTimestamp(LocalDateTime timestamp) { this.timestamp = timestamp; }
}