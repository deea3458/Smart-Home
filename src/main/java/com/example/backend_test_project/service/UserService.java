package com.example.backend_test_project.service;


import com.example.backend_test_project.entity.User;
import com.example.backend_test_project.repository.UserRepository;
import org.apache.tomcat.util.net.openssl.ciphers.Authentication;
//import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;


@Service
public class UserService {

    private final UserRepository userRepository;
    //private final PasswordEncoder passwordEncoder;

    public UserService(UserRepository userRepository) {

        this.userRepository = userRepository;
        //this.passwordEncoder = passwordEncoder;

    }

   /* public User authenticate(String username, String rawPassword) {

        User user = userRepository.findByUsername(username).orElseThrow(() -> new IllegalArgumentException("Invalid credentials"));

        if (!passwordEncoder.matches(rawPassword, user.getPasswordHash())) {
            throw new IllegalArgumentException("Invalid credentials");
        }

        return user;

    }
    */
}
