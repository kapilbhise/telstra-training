package com.programming.SpringBootConcepts.SpringMVCWithSpringBoot.service;

import com.programming.SpringBootConcepts.SpringMVCWithSpringBoot.aspect.Countable;
import com.programming.SpringBootConcepts.SpringMVCWithSpringBoot.aspect.Loggable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.sql.Time;

@Service
public class OutputService {


    @Value("${app.name}")
    private String name;
    private final GreetingService greetingService;
    private final TimeService timeService;

    @Autowired
    public OutputService(GreetingService greetingService, TimeService timeService){
        this.greetingService=greetingService;
        this.timeService=timeService;
    }

    @Loggable
    @Countable
    public  void generateOutput(){
        String output=greetingService.getGreeting(name)+", Current time is :"+timeService.getCurrentTime();
        System.out.println(output);
    }
}
