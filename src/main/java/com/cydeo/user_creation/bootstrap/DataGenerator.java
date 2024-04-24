package com.cydeo.user_creation.bootstrap;

import com.cydeo.user_creation.enums.Gender;
import com.cydeo.user_creation.enums.State;
import com.cydeo.user_creation.model.SecurityModel;
import com.cydeo.user_creation.model.User;
import com.github.javafaker.Faker;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;


@Component
public class DataGenerator {

    public static final List<User> USER_LIST = new ArrayList<>();

    public void createUsers() {
        Faker faker = new Faker();
        for (int i = 0; i < 10; i++) {
            Gender gender = Gender.FEMALE;
            boolean isMarried = i % 3 == 0 ? true : false;
            if (i % 2 == 0) {
                gender = Gender.MALE;
            }
            State state = State.values()[i];
            USER_LIST.add(new User(faker.name().firstName(), faker.name().lastName(), faker.number().numberBetween(18, 75),
                    faker.internet().emailAddress(), new SecurityModel(faker.name().username(),faker.internet().password()),
                    gender, faker.address().fullAddress(), state, isMarried));
        }
    }

    public static void printUsers() {
        USER_LIST.forEach(System.out::println);
    }
}
