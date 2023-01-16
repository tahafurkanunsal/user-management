package tahafurkan.sandbox.usermanagement.service;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tahafurkan.sandbox.usermanagement.dto.UserDto;
import tahafurkan.sandbox.usermanagement.entities.User;
import tahafurkan.sandbox.usermanagement.exception.NoSuchUserExistsException;
import tahafurkan.sandbox.usermanagement.exception.UsernameIsInUseException;
import tahafurkan.sandbox.usermanagement.exception.UsernameUnavailableException;
import tahafurkan.sandbox.usermanagement.repository.AddressRepository;
import tahafurkan.sandbox.usermanagement.repository.UserRepository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private AddressRepository addressRepository;

    @Override
    public UserDto get(int id) {
        Optional<User> user = userRepository.findById(id);
        if (user.isPresent()) {
            return modelMapper.map(user.get(), UserDto.class);
        } else {
            throw new NoSuchUserExistsException("NO USER PRESENT WITH ID = " + id);
        }

    }

    @Override
    public List<UserDto> getAll() {
        List<User> users = userRepository.findAll();
        List<UserDto> userDto = users.stream().map(user -> modelMapper.map(user, UserDto.class)).collect(Collectors.toList());
        return userDto;
    }

    @Override
    public User getByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    @Override
    public List<User> findUserByCity(String city) {
        return addressRepository.findUsersByGivenCity(city);
    }

    @Override
    public User create(User user) {
        checkUsername(user.getUsername());
        return userRepository.save(user);
    }

    @Override
    public UserDto update(int id, UserDto user) {
        User existingUser = userRepository.findById(id).get();
        existingUser.setName(user.getName());
        existingUser.setLastName(user.getLastName());
        existingUser.setEmail(user.getEmail());
        existingUser.setAddress(user.getAddress());
        User updateUser = userRepository.save(existingUser);
        return modelMapper.map(updateUser, UserDto.class);
    }

    @Override
    public void delete(int id) {
        Optional<User> user = userRepository.findById(id);
        if (user.isPresent()) {
            userRepository.deleteById(id);
        } else {
            String msg = String.format(" ID = %d , this ID does not exist  ", id);
            throw new NoSuchUserExistsException(msg);
        }
    }

    @Override
    public void checkUsername(String username) {
        if (username.equalsIgnoreCase("obama")) {
            String msg = String.format("Username = '%s is cannot be used!", username);
            throw new UsernameUnavailableException(msg);
        }
        if (userRepository.existsByUsername(username)) {
            String msg = String.format("Username ='%s' is being used by another user!", username);
            throw new UsernameIsInUseException(msg);
        }
    }

}