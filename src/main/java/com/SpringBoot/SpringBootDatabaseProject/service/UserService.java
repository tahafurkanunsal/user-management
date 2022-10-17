package com.SpringBoot.SpringBootDatabaseProject.service;

import com.SpringBoot.SpringBootDatabaseProject.entities.User;
import com.SpringBoot.SpringBootDatabaseProject.exception.NoSuchUserExistsException;
import com.SpringBoot.SpringBootDatabaseProject.exception.UserAlreadyExistsException;
import com.SpringBoot.SpringBootDatabaseProject.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.List;
import java.util.NoSuchElementException;

import static org.springframework.data.jpa.domain.AbstractPersistable_.id;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User get(int id) {
        return userRepository.findById(id).orElseThrow(() -> new NoSuchUserExistsException("NO USER PRESENT WITH ID = " + id));
    }
    public List<User> getAll(){
        return userRepository.findAll();
    }

    public User create(User user) {
        User existingUser = userRepository.findById(user.getId()).orElse(null);
        if (existingUser != null) {
            throw new UserAlreadyExistsException("User already exists!!");
        }
        return userRepository.save(user);
    }

    public User update(int id , User user) {
        System.out.println("update  user id : " +id);
        User existingUser = userRepository.findById(id).orElse(null);
        if (existingUser == null) {
            throw new NoSuchUserExistsException("No Such User exists :" +id);
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
