package com.example.Quizapp.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Quizapp.Dao.Admindao;
import com.example.Quizapp.model.UserLogin;
import com.example.Quizapp.model.adminRegister;
@Service

public class AdminLoginService {
	
@Autowired 
Admindao admindao;

	 public boolean validateCredentialss(String username, String password,String email) {
	        adminRegister user = admindao.findByUsername(username);
	    	if (user == null) {
	            return false; // User not found
	        }

	        // Compare password and role
	        return user.getPassword().equals(password) ;
}
}