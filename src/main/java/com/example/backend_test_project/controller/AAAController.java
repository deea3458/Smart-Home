package com.example.backend_test_project.controller;

import com.example.backend_test_project.entity.User;
import com.example.backend_test_project.service.DeviceService;
import com.example.backend_test_project.service.HomeService;
import com.example.backend_test_project.service.UserService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
public class AAAController {

    private final UserService userService;
    private final DeviceService deviceService;
    private final HomeService homeService;

    public AAAController(UserService userService, DeviceService deviceService, HomeService homeService) {

        this.userService = userService;
        this.deviceService = deviceService;
        this.homeService = homeService;

    }

   /* @PostMapping("/login")
    public User login(@RequestBody User request) {



    }*/
}
