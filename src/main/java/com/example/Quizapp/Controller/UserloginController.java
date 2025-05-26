package com.example.Quizapp.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.Quizapp.Dao.Userlogindao;
import com.example.Quizapp.Service.UserLoginService;
import com.example.Quizapp.model.UserLogin;


@Controller
public class UserloginController {
@Autowired
UserLoginService userLoginService;
@Autowired
Userlogindao userlogindao;
@GetMapping("/login")
public String showLoginPage() {
    return "login"; 
}
@PostMapping("/api/auth/login")
public String loginPage(@RequestParam(required = false) String username,
                        @RequestParam(required = false) String password,
                        @RequestParam(required = false) String email,
                        Model model) {
    model.addAttribute("username", username);
    model.addAttribute("password", password);
    model.addAttribute("email", email);

    boolean isValid = userLoginService.validateCredentials(username, password, email);

    if (isValid) {
        return "redirect:/user/dashboard";
    } else {
        model.addAttribute("error", "Invalid credentials");
        return "login";
    }
}


@GetMapping("/signup")
public String showRegisterPage(@RequestParam(required = false) String password,
                               @RequestParam(required = false) String username,
                               @RequestParam(required = false) String email,
                               Model model) {

    model.addAttribute("password", password);
    model.addAttribute("username", username);
    model.addAttribute("email", email);
    
    return "register"; 
}

}