package com.cydeo.user_creation.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        //TODO get the static ui page(welcome) if the end point is either / or /welcome
        registry.addViewController("/").setViewName("welcome");
        registry.addViewController("/welcome").setViewName("welcome");


    }
}
