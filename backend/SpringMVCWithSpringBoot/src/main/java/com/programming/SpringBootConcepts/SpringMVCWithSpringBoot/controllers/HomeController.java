package com.programming.SpringBootConcepts.SpringMVCWithSpringBoot.controllers;

import com.programming.SpringBootConcepts.SpringMVCWithSpringBoot.beans.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

@Controller
public class HomeController {

    @GetMapping("/home")
    public String showHomePage() {
        System.out.println("In a Home Controller Class file");
        return "index";
    }

    @GetMapping("/goToSearch")
    public String showSearchPage() {
        System.out.println("Going to search page");
        return "search";
    }

    @GetMapping("/goToLogin")
    public String showLoginPage() {
        System.out.println("Going to login page");
        return "login";
    }

    @GetMapping("/goToRegistration")
    public String showRegistrationPage() {
        System.out.println("Going to registration page");
        return "register";
    }

    @ModelAttribute("newuser")
    public User getDefaultData() {
        return new User();
    }
}
