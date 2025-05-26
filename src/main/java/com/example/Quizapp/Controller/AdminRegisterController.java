package com.example.Quizapp.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.Quizapp.Dao.Admindao;
import com.example.Quizapp.model.adminRegister;

@Controller

@CrossOrigin(origins = "*")
public class AdminRegisterController {
@Autowired
Admindao admindao;
@GetMapping("/adminregister")
public String showLoginPage() {
    return "adminregister"; 
}
	
 @PostMapping("/admin/signup")
 public String registerUserr(@ModelAttribute adminRegister user, Model model) {
	        try {
	            admindao.save(user);
	            System.out.println("User: " + user.getUsername() + ", Email: " + user.getEmail());
	            return "redirect:/admin/dashboard";
	        } catch (Exception e) {
	            e.printStackTrace(); 
	            model.addAttribute("error", "Registration failed: " + e.getMessage());
	            return "admin";  
	        }
	   }

	   @GetMapping("/admin/dashboard")
	    public String showDashboardd() {
	        return "admin";
}

}