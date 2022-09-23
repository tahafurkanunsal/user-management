package com.SpringBoot.SpringBootDatabaseProject.controller;

import com.SpringBoot.SpringBootDatabaseProject.entities.User;
import com.SpringBoot.SpringBootDatabaseProject.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping(path = "/user/save")
    public User addUser(@RequestBody User user) {
        return userService.saveUser(user);
    }

    @PostMapping(path = "/users/save")
    public List<User> addUsers(@RequestBody List<User> user) {
        return userService.saveUsers(user);
    }

    @GetMapping(path = "/users/find")
    public List<User> findAllUsers() {
        return userService.getUsers();
    }

    @GetMapping(path = "/userById/{id}")
    public User findUserById(@PathVariable int id) {
        return userService.getUserById(id);
    }

    @GetMapping(path = "/userByName/{name}")
    public User findUserByName(@PathVariable String name) {
        return userService.getUserByName(name);
    }

    @DeleteMapping(path = "/user/delete/{id}")
    public String deleteUser(@PathVariable int id) {
        return userService.deleteUser(id);
    }

    @PutMapping(path = "/user/update")
    public User updateUser(@RequestBody User user) {
        return userService.updateUser(user);
    }
}
