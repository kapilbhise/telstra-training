package com.programming.SpringBootConcepts.SpringMVCWithSpringBoot.service;

import com.programming.SpringBootConcepts.SpringMVCWithSpringBoot.aspect.Countable;
import com.programming.SpringBootConcepts.SpringMVCWithSpringBoot.aspect.Loggable;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

@Service
public class GreetingService {
    @Value("${app.greeting}")
    private String greeting;

    public GreetingService(){
        super();
    }

    @Loggable
    @Countable
    public  String getGreeting(String name){
        return  greeting+" "+name;
    }
}
