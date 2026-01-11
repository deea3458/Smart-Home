package com.example.backend_test_project.service;

import com.example.backend_test_project.entity.HomeAccount;
import com.example.backend_test_project.entity.User;
import com.example.backend_test_project.repository.HomeRepository;
import org.springframework.stereotype.Service;

@Service
public class HomeService {

    private final HomeRepository homeAccountRepository;

    public HomeService(HomeRepository homeAccountRepository) {

        this.homeAccountRepository = homeAccountRepository;

    }

    public HomeAccount createHome(String name) {

        HomeAccount home = new HomeAccount();
        home.setHomeName(name);

        return homeAccountRepository.save(home);

    }

    public HomeAccount getHomeForUser(User user) {

        return user.getHousehold();

    }

    public HomeAccount getHomeById(Long id) {

        HomeAccount home = homeAccountRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid home id!"));

        return home;

    }
}