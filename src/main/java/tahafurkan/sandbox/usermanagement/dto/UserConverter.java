package tahafurkan.sandbox.usermanagement.dto;

import tahafurkan.sandbox.usermanagement.entities.Address;
import tahafurkan.sandbox.usermanagement.entities.User;

import java.util.List;

public class UserConverter {
    public UserDto toUserDTo(User user) {
        UserDto userDto = new UserDto();
        userDto.setEmail(user.getEmail());
        userDto.setName(user.getName());
        userDto.setLastName(user.getLastName());

        List<Address> address = user.getAddress();

        userDto.setAddress(address);
        return userDto;
    }
}

