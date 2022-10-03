package com.SpringBoot.SpringBootDatabaseProject.service;

import com.SpringBoot.SpringBootDatabaseProject.entities.User;
import com.SpringBoot.SpringBootDatabaseProject.exception.NoSuchUserExistsException;
import com.SpringBoot.SpringBootDatabaseProject.exception.UserAlreadyExistsException;
import com.SpringBoot.SpringBootDatabaseProject.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;


    public User getUser(int id) {
        return userRepository.findById(id).orElseThrow(() -> new NoSuchElementException("NO USER PRESENT WITH ID = " + id));
    }


    public String addUser(User user) {
        User existingUser = userRepository.findById(user.getId()).orElse(null);
        if (existingUser != null) {
            throw new UserAlreadyExistsException("User already exists!!");
        }
        userRepository.save(user);
        return "User added successfully";
    }


    public String updateUser(User user) {
        User existingUser = userRepository.findById(user.getId()).orElse(null);
        if (existingUser == null)
            throw new NoSuchUserExistsException("No Such User exists");
        else {
            existingUser.setName(user.getName());
            existingUser.setLastName(user.getLastName());
            existingUser.setEmail(user.getEmail());
            userRepository.save(existingUser);
            return "Record updated Successfully";
        }
    }


    public String deleteUser(int id) {
        userRepository.deleteById(id);
        return "User removed" + id;
    }
}
