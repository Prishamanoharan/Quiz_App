package com.example.Quizapp.Dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.Quizapp.model.UserLogin;
import com.example.Quizapp.model.adminRegister;
@Repository
public interface Admindao extends JpaRepository<adminRegister, String> {
	adminRegister findByUsername(String username);

}


