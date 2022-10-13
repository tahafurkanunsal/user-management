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

    public User get(int id) {
        return userRepository.findById(id).orElseThrow(() -> new NoSuchElementException("NO USER PRESENT WITH ID = " + id));
    }

    public User create(User user) {
        User existingUser = userRepository.findById(user.getId()).orElse(null);
        if (existingUser != null) {
            throw new UserAlreadyExistsException("User already exists!!");
        }
        return userRepository.save(user);
    }

    public User update(User user) {
        User existingUser = userRepository.findById(user.getId()).orElse(null);
        if (existingUser == null) {
            throw new NoSuchUserExistsException("No Such User exists");
        }

        existingUser.setName(user.getName());
        existingUser.setLastName(user.getLastName());
        existingUser.setEmail(user.getEmail());
        return userRepository.save(existingUser);
    }

    public void delete(int id) {
        userRepository.deleteById(id);
    }
}
