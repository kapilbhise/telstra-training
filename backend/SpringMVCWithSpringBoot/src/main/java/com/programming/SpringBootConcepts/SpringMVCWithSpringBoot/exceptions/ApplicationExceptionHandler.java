package com.programming.SpringBootConcepts.SpringMVCWithSpringBoot.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ApplicationExceptionHandler { // to handle exceptions in controllers

    @ExceptionHandler(ApplicationException.class)
    public String handleException(){
        System.out.println("Handling Exception-LoginController : ApplicationException");
        return "error";
    }

    @ExceptionHandler(LoginFailureException.class)
    public ResponseEntity handleException2(LoginFailureException e){
        System.out.println("Handling Exception-loginRestController :LoginFailureException");
        return ResponseEntity.status(HttpStatus.FORBIDDEN).body(e.getMessage());
    }
}
