package com.programming.SpringBootConcepts.SpringMVCWithSpringBoot.controllers;

import com.programming.SpringBootConcepts.SpringMVCWithSpringBoot.beans.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;
import java.text.SimpleDateFormat;
import java.util.Date;

@Controller
public class RegistrationController {
    @Autowired
    private CrudRepository<User, Integer> userRepository;

//    @InitBinder
//    public  void initBinder(WebDataBinder webDataBinder){
//        webDataBinder.registerCustomEditor(Date.class,"dateOfBirth",
//                new CustomDateEditor(new SimpleDateFormat("yyyy-MM-dd HH-mm-ss"), true));
//    }

    @PostMapping("/registeruser")
    public String registerUser(@Valid @ModelAttribute("newuser") User user, BindingResult result, Model model){

        if(result.hasErrors()){
            return  "register";
        }
        System.out.println("user registered");

        userRepository.save(user);
        model.addAttribute("data saved","user registered successfully");

        return "login";

    }
}
