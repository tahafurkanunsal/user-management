package tahafurkan.sandbox.usermanagement.service;

import tahafurkan.sandbox.usermanagement.dto.UserDto;
import tahafurkan.sandbox.usermanagement.entities.User;

import java.util.List;

public interface UserService {
    public UserDto get(int id);

    public List<UserDto> getAll();

    public User getByUsername(String username);

    public List<User> findUserByCity(String city);

    public User create(User user);

    public UserDto update(int id, UserDto user);

    public void delete(int id);

    public void checkUsername(String username);
}
