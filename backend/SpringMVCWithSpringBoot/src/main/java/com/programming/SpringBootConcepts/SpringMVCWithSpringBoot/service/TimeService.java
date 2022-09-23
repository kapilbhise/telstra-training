package com.programming.SpringBootConcepts.SpringMVCWithSpringBoot.service;

import com.programming.SpringBootConcepts.SpringMVCWithSpringBoot.aspect.Countable;
import com.programming.SpringBootConcepts.SpringMVCWithSpringBoot.aspect.Loggable;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Service
public class TimeService {

    private static  final DateTimeFormatter formatter24=DateTimeFormatter.ofPattern("HH-mm-ss");
    private static  final DateTimeFormatter formatter12=DateTimeFormatter.ofPattern("HH-mm-ss a");

    @Value("true")
    private boolean is24;

    public TimeService(){
        super();
    }

    @Loggable
    @Countable
    public String getCurrentTime(){
        LocalDateTime currentTime=LocalDateTime.now();
        if(is24){
            return formatter24.format(currentTime);
        }
        else{
            return formatter12.format(currentTime);
        }
    }




}
