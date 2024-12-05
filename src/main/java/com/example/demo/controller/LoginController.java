package com.example.demo.controller;

import com.example.demo.model.UserLogin;
import com.example.demo.service.UserService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.LinkedList;
import java.util.List;

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
    public String registerForm(HttpServletRequest request) {
             UserLogin userLogin = new UserLogin();
             userLogin.setUsername(request.getParameter("username"));
             userLogin.setPassword(request.getParameter("password"));
             userLogin.setEmail(request.getParameter("email"));
              userService.savaUser(userLogin);
              return "redirect:/login";
    }
    @GetMapping("/register")
    public String register() {
        return "register";
    }
    @GetMapping("display")
    public String display(Model model ) {
        List<UserLogin> list = userService.findAllDetail();
        model.addAttribute("users", list);
        return "display";
    }
    @PutMapping("display")
    public void update(@RequestParam int id,@RequestParam String username, @RequestParam String email) {
        System.out.println("Updating user: ID=" + id + ", Username=" + username + ", Email=" + email);
        userService.updateUser(id,username,email);
    }
   @DeleteMapping("display")
    public void delete(@RequestParam int id) {
        userService.deleteData(id);
   }
}
