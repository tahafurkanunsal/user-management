package tahafurkan.sandbox.usermanagement.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.DeleteMapping;

import tahafurkan.sandbox.usermanagement.dto.UserDto;
import tahafurkan.sandbox.usermanagement.entities.User;
import tahafurkan.sandbox.usermanagement.service.UserService;

import java.util.List;


@RestController
@RequestMapping(path = "/api")
public class UserController {

    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping(value = "/users", params = {"id"})
    public UserDto get(@RequestParam("id") int id) {
        return userService.get(id);
    }

    @GetMapping(value = "/users", params = {"username"})
    public User getByUsername(@RequestParam("username") String username) {
        return userService.getByUsername(username);
    }

    @GetMapping("/users")
    public List<UserDto> getAll() {
        return userService.getAll();
    }

    @GetMapping(value = "/users", params = {"city"})
    public List<User> findUserByGivenCity(@RequestParam("city") String city) {
        return userService.findUserByCity(city);

    }

    @PostMapping("/users")
    public User add(@RequestBody User user) {
        return userService.create(user);
    }

    @PutMapping("/users/{id}")
    public UserDto update(@PathVariable int id, @RequestBody UserDto user) {
        return userService.update(id, user);
    }

    @DeleteMapping("/users/{id}")
    public void delete(@PathVariable int id) {
        userService.delete(id);
    }
}