package com.programming.SpringBootConcepts.SpringMVCWithSpringBoot.restcotrollers;


import com.programming.SpringBootConcepts.SpringMVCWithSpringBoot.beans.User;
import com.programming.SpringBootConcepts.SpringMVCWithSpringBoot.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class UserRestController {
    @Autowired
    private UserRepository userRepository;

    @GetMapping("/hplus/rest/users")
    @ResponseBody
    public List<User> getUsers(){
        List<User> userList= new ArrayList<>();
        userRepository.findAll().forEach(user->userList.add(user));
        return userList;
    }


}
