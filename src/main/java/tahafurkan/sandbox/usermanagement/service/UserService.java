package tahafurkan.sandbox.usermanagement.service;

import tahafurkan.sandbox.usermanagement.entities.User;
import tahafurkan.sandbox.usermanagement.exception.NoSuchUserExistsException;
import tahafurkan.sandbox.usermanagement.exception.UserAlreadyExistsException;
import tahafurkan.sandbox.usermanagement.exception.UsernameAlreadyExistsException;
import tahafurkan.sandbox.usermanagement.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public User get(int id) {
        return userRepository.findById(id).orElseThrow(() -> new NoSuchUserExistsException("NO USER PRESENT WITH ID = " + id));
    }

    public List<User> getAll() {
        return userRepository.findAll();
    }

    public User getByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    public User create(User user) {
        boolean usernameAlreadyExist = userRepository.existsByUsername(user.getUsername());
        if (usernameAlreadyExist) {
            throw new UsernameAlreadyExistsException("Username already exists");
        }

        return userRepository.save(user);
    }

    public User update(int id, User user) {
        User existingUser = get(id);
        existingUser.setName(user.getName());
        existingUser.setLastName(user.getLastName());
        existingUser.setEmail(user.getEmail());
        existingUser.setUsername(user.getUsername());
        if (userRepository.existsByUsername(user.getUsername())) {
            throw new UsernameAlreadyExistsException("Username already exists");
        }
        return userRepository.save(existingUser);
    }

    public void delete(int id) {
        userRepository.deleteById(id);
    }


}
