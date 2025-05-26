package com.example.Quizapp.Dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import com.example.Quizapp.Service.UserLoginService;
import com.example.Quizapp.model.UserLogin;

@Repository
public interface Userlogindao extends JpaRepository<UserLogin, String> {
	UserLogin findByUsername(String username);
}


