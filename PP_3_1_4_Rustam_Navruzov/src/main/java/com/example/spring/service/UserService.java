package com.example.spring.service;


import com.example.spring.model.User;

import java.util.List;

public interface UserService {

    boolean addUser(User user);

    User getUserById(Long id);

    boolean updateUser(User user);

    boolean deleteUserById(Long id);

    List<User> getAllUsers();

    User getUserByUsername(String name);
}