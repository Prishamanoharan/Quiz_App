package com.example.Quizapp.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.Quizapp.Dao.Admindao;
import com.example.Quizapp.Dao.Userlogindao;
import com.example.Quizapp.model.UserLogin;
import com.example.Quizapp.model.adminRegister;

@Controller

@CrossOrigin(origins = "*")
public class RegisterController {

    @Autowired
    private Userlogindao userlogindao;
    @Autowired
    private Admindao admindao;

    @PostMapping("/register")
    public String registerUser(@ModelAttribute UserLogin user, Model model) {
        try {
            userlogindao.save(user);
            System.out.println("User: " + user.getUsername() + ", Email: " + user.getEmail());
            return "redirect:/user/dashboard";
        } catch (Exception e) {
            e.printStackTrace(); // ✅ Now correctly inside catch block
            model.addAttribute("error", "Registration failed: " + e.getMessage());
            return "register";  // back to register page on error
        }
    }
 
    @GetMapping("/user/dashboard")
    public String showDashboard() {
        return "dashboard"; // dashboard.html or dashboard.html in templates
    }
    
}
