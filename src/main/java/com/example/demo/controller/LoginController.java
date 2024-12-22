package com.example.demo.controller;

import com.example.demo.model.UserLogin;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class LoginController {

    @Autowired
    private UserService userService;

    @GetMapping("/login")
    public String loginForm() {
        System.out.println("loginForm");
        return "login";
    }
    @PostMapping("/register")
    public String registerForm(@ModelAttribute UserLogin userLogin) {
//             UserLogin userLogin = new UserLogin();
//             userLogin.setUsername(request.getParameter("username"));
//             userLogin.setPassword(request.getParameter("password"));
//             userLogin.setEmail(request.getParameter("email"));
              userService.savaUser(userLogin);
              return "redirect:/login";
    }
    @GetMapping("/register")
    public String register() {
        return "register";
    }

   @GetMapping("/home")
    public String home() {
        return "home";
   }
}
