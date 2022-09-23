package com.programming.SpringBootConcepts.SpringMVCWithSpringBoot.aspect;


import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Collection;

//spring automatically detects it
@Component
@Aspect
public class LoggingAspect {

    private static  final Logger logger= LoggerFactory.getLogger(LoggingAspect.class);
    @Pointcut("@annotation(Loggable)")
    public  void executeLogging(){

    }

    //Advice
//    @Before("executeLogging()")
//    public void logDifferentMethodCalls(JoinPoint joinPoint){
//        StringBuilder message= new StringBuilder("Method :");
//        message.append(joinPoint.getSignature().getName());
//        Object [] args= joinPoint.getArgs();
//        if(null!= args && args.length>0){
//            message.append("args=[ | ");
//            Arrays.asList(args).forEach(arg-> message.append(arg).append(" | "));
//            message.append(" ]");
//
//        }
//        logger.info(message.toString());
//    }
//
//    @After("executeLogging()")
//    public void logDifferentMethodCalls(JoinPoint joinPoint, Object returnValue ){
//        StringBuilder message= new StringBuilder("Method :");
//        message.append(joinPoint.getSignature().getName());
//        Object [] args= joinPoint.getArgs();
//
//        if(null!= args && args.length>0){
//            message.append("args=[ | ");
//            Arrays.asList(args).forEach(arg-> message.append(arg).append(" | "));
//            message.append(" ]");
//
//        }
//        if(null!=returnValue){
//            if(returnValue instanceof Collection<?>){
//                message.append(", returning :").append(((Collection)returnValue).size()).append(" instance");
//
//            }else{
//                message.append(", returning :").append(returnValue.toString());
//            }
//        }
//
//        logger.info(message.toString());
//    }

    @AfterReturning(value = "executeLogging()", returning = "returnValue")
    public void logDifferentMethodCalls(JoinPoint joinPoint, Object returnValue ){
        StringBuilder message= new StringBuilder("Method :");
        message.append(joinPoint.getSignature().getName());
        Object [] args= joinPoint.getArgs();

        if(null!= args && args.length>0){
            message.append("args=[ | ");
            Arrays.asList(args).forEach(arg-> message.append(arg).append(" | "));
            message.append(" ]");

        }
        if(null!=returnValue){
            if(returnValue instanceof Collection<?>){
                message.append(", returning :").append(((Collection)returnValue).size()).append(" instance");

            }else{
                message.append(", returning :").append(returnValue.toString());
            }
        }

        logger.info(message.toString());
    }


//    @Around(value = "executeLogging()")
//    public void logDifferentMethodCalls(ProceedingJoinPoint joinPoint) throws Throwable {
//        long  startTime=System.currentTimeMillis();
//        Object returnValue=joinPoint.proceed();
//        long totalTime=System.currentTimeMillis()-startTime;
//
//        StringBuilder message= new StringBuilder("Method :");
//        message.append(joinPoint.getSignature().getName());
//
//        message.append("Total time: ").append(totalTime).append(" ms");
//        Object [] args= joinPoint.getArgs();
//
//        if(null!= args && args.length>0){
//            message.append("args=[ | ");
//            Arrays.asList(args).forEach(arg-> message.append(arg).append(" | "));
//            message.append(" ]");
//
//        }
//        if(null!=returnValue){
//            if(returnValue instanceof Collection<?>){
//                message.append(", returning :").append(((Collection)returnValue).size()).append(" instance");
//
//            }else{
//                message.append(", returning :").append(returnValue.toString());
//            }
//        }
//
//        logger.info(message.toString());
//    }
}
