package com.example.backend_test_project.controller;

import com.example.backend_test_project.entity.User;
import com.example.backend_test_project.service.UserService;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {

        this.userService = userService;

    }

   /* @GetMapping("/profile")
    public User myProfile() {



    }

    @PutMapping("/profile")
    public void updateProfile() {



    }

    @DeleteMapping("/{userId}")
    @PreAuthorize("hasRole('ADMIN')")
    public void removeUser(@PathVariable Long userId) {

        userService.removeUser(userId);

    }*/
}
