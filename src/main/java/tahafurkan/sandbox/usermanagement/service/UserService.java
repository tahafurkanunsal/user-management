package tahafurkan.sandbox.usermanagement.service;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tahafurkan.sandbox.usermanagement.dto.UserDto;
import tahafurkan.sandbox.usermanagement.entities.User;
import tahafurkan.sandbox.usermanagement.exception.NoSuchUserExistsException;
import tahafurkan.sandbox.usermanagement.exception.UsernameIsInUseException;
import tahafurkan.sandbox.usermanagement.exception.UsernameUnavailableException;
import tahafurkan.sandbox.usermanagement.repository.UserRepository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private ModelMapper modelMapper;

    public UserDto get(int id) {
        Optional<User> user = userRepository.findById(id);
        if (user.isPresent()) {
            return modelMapper.map(user.get(), UserDto.class);
        } else {
            throw new NoSuchUserExistsException("NO USER PRESENT WITH ID = " + id);
        }

    }

    public List<UserDto> getAll() {
        List<User> users = userRepository.findAll();
        List<UserDto> userDto = users.stream().map(user -> modelMapper.map(user, UserDto.class)).collect(Collectors.toList());
        return userDto;
    }

    public User getByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    public User create(User user) {
        checkUsername(user.getUsername());
        return userRepository.save(user);
    }

    public UserDto update(int id, UserDto user) {
        UserDto existingUser = get(id);
        existingUser.setName(user.getName());
        existingUser.setLastName(user.getLastName());
        existingUser.setEmail(user.getEmail());
        existingUser.setAddress(user.getAddress());
        return modelMapper.map(existingUser, UserDto.class);
    }

    public void delete(int id) {
        userRepository.deleteById(id);
    }

    private void checkUsername(String username) {
        if (username.equals("dummy")) {
            String msg = String.format("Username = '%s is cannot be used!", username);
            throw new UsernameUnavailableException(msg);
        } else if (!userRepository.existsByUsername(username)) return;

        String msg = String.format("Username ='s%s' is being used by another user!", username);
        throw new UsernameIsInUseException(msg);

    }

}
