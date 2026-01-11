package com.example.backend_test_project.service;

import com.example.backend_test_project.entity.ActuatorCommand;

public interface ActuatorHandler {

    String getActuatorType();

    void handle(ActuatorCommand command) throws Exception;

}