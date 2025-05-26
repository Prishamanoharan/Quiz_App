package com.example.Quizapp.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Quizapp.Dao.Admindao;
import com.example.Quizapp.Dao.Userlogindao;
import com.example.Quizapp.model.UserLogin;
@Service

public class UserLoginService {
@Autowired

Userlogindao userlogindao;


public boolean validateCredentials(String username, String password,String email) {
    UserLogin user = userlogindao.findByUsername(username);
	if (user == null) {
        return false; // User not found
    }

    // Compare password and role
    return user.getPassword().equals(password) ;
        
}
}	
	