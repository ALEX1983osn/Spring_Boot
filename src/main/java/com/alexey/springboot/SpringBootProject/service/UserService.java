package com.alexey.springboot.SpringBootProject.service;

import com.alexey.springboot.SpringBootProject.model.User;

import java.util.List;

public interface UserService {

    List<User> getAllUsers();

    void saveUser(User user);

    void deleteUser(Long id);

    User update(Long id);
}