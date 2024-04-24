package com.cydeo.user_creation.service.implementation;


import com.cydeo.user_creation.bootstrap.DataGenerator;
import com.cydeo.user_creation.model.User;
import com.cydeo.user_creation.service.UserService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;

@Service
public class UserServiceImplementation implements UserService {
    private static final Logger logger = Logger.getLogger(UserServiceImplementation.class.getName());

    @Override
    public List<User> getUsers() {
        return DataGenerator.USER_LIST;
    }

    @Override
    public void save(User user) {
        DataGenerator.USER_LIST.add(user);
        logger.log(Level.INFO,"Print users after create");
        DataGenerator.printUsers();
    }

    @Override
    public User findByEmail(String email) {
        return getUsers().stream().filter(user -> user.getEmail().equals(email)).findFirst().orElseThrow();
    }

    @Override
    public void update(User user) {
        User userInDB = findByEmail(user.getEmail());
        getUsers().remove(userInDB);
        save(user);
        logger.log(Level.INFO,"Print updated user after update");
        System.out.println(findByEmail(user.getEmail()));
    }

    @Override
    public void deleteByEmail(String email) {
        getUsers().remove(findByEmail(email));
        logger.log(Level.INFO,"Print users after delete");
        DataGenerator.printUsers();
    }

    @Override
    public List<User> findAllUsersWithFirstName(String firstName) {
        return getUsers().stream().filter(user -> user.getFirstName().contains(firstName)).collect(Collectors.toList());
    }

}
