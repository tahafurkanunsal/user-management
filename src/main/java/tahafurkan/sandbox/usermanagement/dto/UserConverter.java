package tahafurkan.sandbox.usermanagement.dto;

import tahafurkan.sandbox.usermanagement.entities.Address;
import tahafurkan.sandbox.usermanagement.entities.User;

import java.util.ArrayList;
import java.util.List;

public class UserConverter {
    public UserDto toUserDTo(User user) {
        UserDto userDto = new UserDto();
        userDto.setEmail(user.getEmail());
        userDto.setName(user.getName());
        userDto.setLastName(user.getLastName());


        List<Address> addresses = user.getAddress();

        List<AddressDto> addressDtoList = new ArrayList<>();
        for(Address address : addresses) {
            AddressDto addressDto = new AddressDto();
            addressDto.setCity(address.getCity());
           addressDto.setDistrict(address.getDistrict());
           addressDto.setAddressName(address.getAddressName());
            addressDtoList.add(addressDto);
        }
        userDto.setAddress(addresses);
        return userDto;
    }
}

