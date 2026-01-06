package com.example.backend_test_project.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "actuator_commands")
public class ActuatorCommand {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    //re-evaluate whether these are the correct fields to have bor a
    private String deviceId;
    private String actuator;
    private double value;
    private boolean executed = false;
    private LocalDateTime timestamp = LocalDateTime.now();

    //getters and setters
    public Long getId() {return id;}
    public void setId(Long id) {this.id = id;}
    public String getDeviceId() {return deviceId;}
    public void setDeviceId(String deviceId) {this.deviceId = deviceId;}
    public double getValue() {return value;}
    public void setValue(double value) {this.value = value;}
    public String getActuator() {return actuator;}
    public void setActuator(String actuator) {this.actuator = actuator;}
    public boolean isExecuted() {return executed;}
    public void setExecuted(boolean executed) {this.executed = executed;}
    public LocalDateTime getTimestamp() {return timestamp;}
    public void setTimestamp(LocalDateTime timestamp) {this.timestamp = timestamp;}
}

