package com.babustore.www.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.babustore.www.model.Login;

@Repository
public interface LoginRepository extends JpaRepository<Login, Long> {

  
    Login findByUsername(String username);
}
