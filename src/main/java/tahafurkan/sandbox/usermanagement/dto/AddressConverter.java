package tahafurkan.sandbox.usermanagement.dto;

import tahafurkan.sandbox.usermanagement.entities.Address;

import java.util.ArrayList;
import java.util.List;

public class AddressConverter {
    public void toAddressDto(Address address) {

        List<AddressDto> addressDtoList = new ArrayList<>();

        AddressDto addressDto = new AddressDto();
        addressDto.setCity(address.getCity());
        addressDto.setDistrict(address.getDistrict());
        addressDto.setAddressName(address.getAddressName());
        addressDtoList.add(addressDto);

    }
}

