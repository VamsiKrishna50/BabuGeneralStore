package com.babustore.www.service;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.babustore.www.model.Login;
import com.babustore.www.repository.LoginRepository;

@Service
public class LoginService {

    @Autowired
    public LoginRepository loginRepository;

    

    public Login authenticateUser(String username, String password) {
        Login user = loginRepository.findByUsername(username);
        if (user != null && password.equals(user.getPassword())) {
            return user;
        }
        return null;
    }

    public Login saveLoginDetails(Login login) {
       
        return loginRepository.save(login);
    }
}
