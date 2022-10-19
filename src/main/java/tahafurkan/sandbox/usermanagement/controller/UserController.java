package tahafurkan.sandbox.usermanagement.controller;

import tahafurkan.sandbox.usermanagement.entities.User;
import tahafurkan.sandbox.usermanagement.service.UserService;
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
    @GetMapping("/users")
    public List<User> getAll(){
        return userService.getAll();
    }
    @GetMapping("/users/v1/{userName}")
    public User read(@PathVariable String userName){
        return userService.read(userName);
    }

    @PostMapping("/users")
    public User add(@RequestBody User user) {
        return userService.create(user);
    }

    @PutMapping("/users/{id}")
    public User update(@PathVariable int id, @RequestBody User user) {
        return userService.update(id, user);
    }

    @DeleteMapping("/users/{id}")
    public void delete(@PathVariable int id) {
        userService.delete(id);

    }
}
