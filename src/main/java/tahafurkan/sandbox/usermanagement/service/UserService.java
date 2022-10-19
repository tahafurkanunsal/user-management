package tahafurkan.sandbox.usermanagement.service;

import tahafurkan.sandbox.usermanagement.entities.User;
import tahafurkan.sandbox.usermanagement.exception.NoSuchUserExistsException;
import tahafurkan.sandbox.usermanagement.exception.UserAlreadyExistsException;
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
    public User read(String userName){
        return userRepository.findByUserName(userName);
    }

    public User create(User user) {
        boolean userAlreadyExist = userRepository.existsByUserName(user.getUserName());
        if (userAlreadyExist) {
            throw new UserAlreadyExistsException("User already exists");
        }

        return userRepository.save(user);
    }

    public User update(int id, User user) {
        User existingUser = get(id);
        existingUser.setName(user.getName());
        existingUser.setLastName(user.getLastName());
        existingUser.setEmail(user.getEmail());
        existingUser.setUserName(user.getUserName());
        return userRepository.save(existingUser);
    }

    public void delete(int id) {
        userRepository.deleteById(id);
    }


}
