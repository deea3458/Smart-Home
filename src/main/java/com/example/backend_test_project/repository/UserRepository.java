package com.example.backend_test_project.repository;

import com.example.backend_test_project.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User,Long>{

    // Using Optional eliminates the need for @Nullable and try catch for NullPointerException
    Optional<User> findByUsername(String username);

    Optional<User> findByEmail(String email);

    List<User> findByHouseholdId(Long householdId);
}
