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

    @GetMapping("/users/{id}")
    public User get(@PathVariable int id) {
        return userService.get(id);
    }
    @GetMapping(path = "/users")
    public List<User> getAll(){
        return userService.getAll();
    }

    @PostMapping("/users")
    public User add(@RequestBody User user) {
        return userService.create(user);
    }

    @PutMapping("/users/{id}")
    public User update(@PathVariable int id , @RequestBody User user) {
        System.out.println("id:" +id);
        return userService.update(id, user);
    }

    @DeleteMapping("/users/{id}")
    public void delete(@PathVariable int id) {
        userService.delete(id);

    }
}
