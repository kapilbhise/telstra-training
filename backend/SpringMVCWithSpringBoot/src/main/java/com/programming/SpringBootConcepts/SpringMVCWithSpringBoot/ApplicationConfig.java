package com.programming.SpringBootConcepts.SpringMVCWithSpringBoot;

import com.programming.SpringBootConcepts.SpringMVCWithSpringBoot.convertors.StringToEnumConvertor;
import org.springframework.context.annotation.*;
import org.springframework.core.task.AsyncTaskExecutor;
import org.springframework.format.FormatterRegistry;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.config.annotation.AsyncSupportConfigurer;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

import java.util.concurrent.ThreadPoolExecutor;

@PropertySource("classpath:application.properties")
@Configuration
@ComponentScan(basePackages = "com.programming.SpringMVCUsingSpringBoot")
@EnableAspectJAutoProxy
public class ApplicationConfig extends WebMvcConfigurationSupport {
    @Override
    protected void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("static/css/**","images/**").
                addResourceLocations("classpath:/static/css/","classpath:/static/images/");
    }

    @Bean
    public InternalResourceViewResolver jspViewResolver(){
        InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
        viewResolver.setPrefix("/WEB-INF/jsp/");
        viewResolver.setSuffix(".jsp");
        viewResolver.setViewClass(JstlView.class);
        return viewResolver;
    }

//    @Override
//    protected void addFormatters(FormatterRegistry registry){
//        registry.addConverter(new StringToEnumConvertor());
//    }

    @Override
    protected void configureAsyncSupport(AsyncSupportConfigurer configurer){
        configurer.setDefaultTimeout(5000);
        configurer.setTaskExecutor(mvcTaskExecutor());
    }

    @Bean
    public AsyncTaskExecutor mvcTaskExecutor(){
        ThreadPoolTaskExecutor threadPoolTaskExecutor=new ThreadPoolTaskExecutor();
        threadPoolTaskExecutor.setThreadNamePrefix("hplus-thread-");
        return  threadPoolTaskExecutor;
    }



}
