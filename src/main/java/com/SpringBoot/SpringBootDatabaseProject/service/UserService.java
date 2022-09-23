package com.SpringBoot.SpringBootDatabaseProject.service;

import com.SpringBoot.SpringBootDatabaseProject.entities.User;
import com.SpringBoot.SpringBootDatabaseProject.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public User saveUser(User user) {
        return userRepository.save(user);
    }

    public List<User> saveUsers(List<User> user) {
        return userRepository.saveAll(user);
    }

    public List<User> getUsers() {
        return userRepository.findAll();
    }

    public User getUserById(int id) {
        return userRepository.findById(id).orElse(null);
    }

    public User getUserByName(String name) {
        return userRepository.findByName(name);
    }

    public String deleteUser(int id) {
        userRepository.deleteById(id);
        return "User removed !";
    }

    public User updateUser(User user) {
        User updateUser = userRepository.findById(user.getId()).orElse(null);
        updateUser.setName(user.getName());
        updateUser.setEmail(user.getEmail());
        updateUser.setLastName(user.getLastName());
        return userRepository.save(updateUser);
    }


}
