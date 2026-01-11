package com.example.backend_test_project.repository;

import com.example.backend_test_project.entity.HomeAccount;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HomeRepository extends JpaRepository<HomeAccount, Long> {


}