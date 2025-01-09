package com.babustore.www.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.babustore.www.model.Login;
import com.babustore.www.service.LoginService;

@RestController
@RequestMapping("/api/login")
@CrossOrigin(origins = "*")
public class LoginController {

    @Autowired
    private LoginService loginService;
    
    
    @PostMapping("/authenticate")
    public ResponseEntity<?> authenticateUser(@RequestBody Login loginRequest) {
        Login user = loginService.authenticateUser(loginRequest.getUsername(), loginRequest.getPassword());
        if (user != null) {
            return ResponseEntity.ok(user); // or return token/details as needed
        } else {
            return ResponseEntity.status(401).body("Invalid username or password");
        }
    }

    @PostMapping("/register")
    public ResponseEntity<Login> registerUser(@RequestBody Login login) {
        Login savedUser = loginService.saveLoginDetails(login);
        return ResponseEntity.ok(savedUser);
    }
}
