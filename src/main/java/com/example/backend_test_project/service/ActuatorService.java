package com.example.backend_test_project.service;

import com.example.backend_test_project.entity.ActuatorCommand;
import com.example.backend_test_project.repository.ActuatorRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class ActuatorService {

    private final ActuatorRepository actuatorRepository;
    private final Map<String, ActuatorHandler> handlers;

    public ActuatorService(ActuatorRepository actuatorRepository, List<ActuatorHandler> handlerList) {

        this.actuatorRepository = actuatorRepository;
        this.handlers = handlerList.stream().collect(Collectors.toMap(h -> h.getActuatorType().toLowerCase(), h -> h));

    }

    public void processCommand(ActuatorCommand command) throws Exception {

        ActuatorHandler handler = handlers.get(command.getActuator().toLowerCase());

        if (handler == null) {

            throw new IllegalArgumentException("Unknown actuator: " + command.getActuator());

        }

        command.setTimestamp(LocalDateTime.now());

        try {

            handler.handle(command);
            command.setExecuted(true);

        } catch (Exception e) {

            command.setExecuted(false);
            throw e;

        } finally {

            actuatorRepository.save(command);

        }
    }
}