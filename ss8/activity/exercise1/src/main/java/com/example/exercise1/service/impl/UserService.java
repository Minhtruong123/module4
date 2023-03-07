package com.example.exercise1.service.impl;

import com.example.exercise1.model.User;
import com.example.exercise1.repository.IUserRepository;
import com.example.exercise1.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService implements IUserService {
    @Autowired
    private IUserRepository userRepository;

    @Override
    public List<User> listAllUser() {
        return userRepository.findAll();
    }

    @Override
    public void addUser(User user) {
        userRepository.save(user);
    }
}
