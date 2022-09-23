package com.programming.SpringBootConcepts.SpringMVCWithSpringBoot.restcotrollers;


import com.programming.SpringBootConcepts.SpringMVCWithSpringBoot.beans.Login;
import com.programming.SpringBootConcepts.SpringMVCWithSpringBoot.beans.User;
import com.programming.SpringBootConcepts.SpringMVCWithSpringBoot.exceptions.LoginFailureException;
import com.programming.SpringBootConcepts.SpringMVCWithSpringBoot.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.security.auth.login.LoginException;

@RestController
public class LoginRestController {
    @Autowired
    private UserRepository userRepository;

    @PostMapping("/hplus/rest/users")
    public ResponseEntity loginUser(@RequestBody Login login) throws LoginFailureException{
        System.out.println(login.getUsername()+" "+login.getPassword());
        User user= userRepository.searchByName(login.getUsername());
        if(user==null){
//            return  ResponseEntity.status(404).build();
            return new ResponseEntity<>("user is not found in db! ", HttpStatus.NOT_FOUND);
        }
        if(user.getUsername().equals(login.getUsername()) &&
                user.getPassword().equals(login.getPassword())){

//            return new ResponseEntity(HttpStatus.OK);
            return new ResponseEntity<>("Welcome "+ user.getUsername(), HttpStatus.OK);

        }
        else{
            throw new LoginFailureException("Invalid username or invalid password");
        }

    }



}
