package com.programming.SpringBootConcepts.SpringMVCWithSpringBoot.controllers;

import com.programming.SpringBootConcepts.SpringMVCWithSpringBoot.beans.Login;
import com.programming.SpringBootConcepts.SpringMVCWithSpringBoot.beans.User;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;

import java.util.Arrays;
import java.util.List;

@ControllerAdvice
public class DefaultModelAttributeController {

    @ModelAttribute("newuser")
    public  User getDefaultUserData(){return  new User();}

    public List<String> getGenderItems(){
        return Arrays.asList(new String[] {"Male","Female", "Other"});
    }
    @ModelAttribute("login")
    public Login getDefaultLogin(){
        return new Login();
    }

}
