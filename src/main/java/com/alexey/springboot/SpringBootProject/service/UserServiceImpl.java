package com.alexey.springboot.SpringBootProject.service;

import com.alexey.springboot.SpringBootProject.model.User;
import com.alexey.springboot.SpringBootProject.reposetory.UserRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public void saveUser(User user) {
        userRepository.save(user);
    }

    @Override
    public User update(Long id) {
        Optional<User> optional = userRepository.findById(id);
        if (optional.isPresent()) {
            return optional.get();
        } else {
            throw new EntityNotFoundException("Пользователь не существует: " + id);
        }
    }


    @Override
    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }
}