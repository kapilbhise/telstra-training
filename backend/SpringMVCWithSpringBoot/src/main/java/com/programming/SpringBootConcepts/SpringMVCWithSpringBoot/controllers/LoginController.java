package com.programming.SpringBootConcepts.SpringMVCWithSpringBoot.controllers;

import com.programming.SpringBootConcepts.SpringMVCWithSpringBoot.aspect.Loggable;
import com.programming.SpringBootConcepts.SpringMVCWithSpringBoot.beans.Login;
import com.programming.SpringBootConcepts.SpringMVCWithSpringBoot.beans.User;
import com.programming.SpringBootConcepts.SpringMVCWithSpringBoot.exceptions.ApplicationException;
import com.programming.SpringBootConcepts.SpringMVCWithSpringBoot.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.task.AsyncTaskExecutor;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.context.request.async.DeferredResult;

import javax.servlet.http.HttpServletRequest;
import java.util.concurrent.Callable;
@Controller
public class LoginController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private AsyncTaskExecutor asyncTaskExecutor;

//    @PostMapping("/login")
//    @Loggable
//    public  Callable<String> login(@ModelAttribute("login") Login login, HttpServletRequest request) throws ApplicationException {
//        System.out.println("Username: "+login.getUsername());
//        System.out.println("Is asynchronous programming supported: "+ request.isAsyncSupported());
//        System.out.println("Default thread name is: "+Thread.currentThread().getName());
//
//
//        return () -> {
//            Thread.sleep(3000);
//            System.out.println("Thread created by mvc task executor is: "+ Thread.currentThread().getName());
//
//            User user=userRepository.searchByName(login.getUsername());
//            if(user==null){
//                throw new ApplicationException("User Not found");
//            }
//            return "search";
//        };
//    }

    @PostMapping("/login")
    @Loggable
    public DeferredResult<String> login(@ModelAttribute("login") Login login, HttpServletRequest request) throws ApplicationException {

        DeferredResult<String> deferredResult= new DeferredResult<>();

        System.out.println("Username: "+login.getUsername());
        System.out.println("Is asynchronous programming supported: "+ request.isAsyncSupported());
        System.out.println("Default thread name is: "+Thread.currentThread().getName());


        asyncTaskExecutor.execute(()->{
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("Thread created by mvc task executor is: "+ Thread.currentThread().getName());

            User user=userRepository.searchByName(login.getUsername());
            if(user==null){
                try {
                    throw new ApplicationException("User Not found");
                } catch (ApplicationException e) {
                    throw new RuntimeException(e);
                }
            }
            deferredResult.setResult("search");
        });
        return deferredResult;
//        return () -> {
//            Thread.sleep(3000);
//            System.out.println("Thread created by mvc task executor is: "+ Thread.currentThread().getName());
//
//            User user=userRepository.searchByName(login.getUsername());
//            if(user==null){
//                throw new ApplicationException("User Not found");
//            }
//            return "search";
//        };


    }



}
