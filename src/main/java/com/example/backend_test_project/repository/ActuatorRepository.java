package com.example.backend_test_project.repository;

import com.example.backend_test_project.entity.ActuatorCommand;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ActuatorRepository extends JpaRepository<ActuatorCommand, Long> {

    List<ActuatorCommand> findByDeviceUId(String deviceId, Pageable pageable);

}