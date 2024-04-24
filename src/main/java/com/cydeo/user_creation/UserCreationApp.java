package com.cydeo.user_creation;

import com.cydeo.user_creation.bootstrap.DataGenerator;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class UserCreationApp {

    public static void main(String[] args) {
        ConfigurableApplicationContext container = SpringApplication.run(UserCreationApp.class, args);
        DataGenerator dataGenerator = container.getBean(DataGenerator.class);
        dataGenerator.createUsers();
    }

}
