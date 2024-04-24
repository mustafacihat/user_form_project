package com.cydeo.user_creation.service;


import com.cydeo.user_creation.model.User;

import java.util.List;

public interface UserService {

    public List<User> getUsers();

    public void save(User user);

    User findByEmail(String email);

    void update(User user);

    void deleteByEmail(String email);

    List<User> findAllUsersWithFirstName(String firstName);

}
