package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class SecurityController {

    @GetMapping("/login")
    public String showLoginPage() {
        return "login";
    }

    @PostMapping("/login")
    public String login(@RequestParam String username, @RequestParam String password) {
        // Check if the username and password are correct (admin/admin)
        if ("admin".equals(username) && "admin".equals(password)) {
            return "redirect:/main";
        }
        return "login";
    }

    @PostMapping("/logout")
    public String logout() {
        // Perform the logout operation
        return "redirect:/login";
    }
}
