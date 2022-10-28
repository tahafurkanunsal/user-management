package tahafurkan.sandbox.usermanagement.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import tahafurkan.sandbox.usermanagement.entities.Address;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDto {

    private int id;
    private String name;
    private String lastName;
    private String email;
    private List<Address> address = new ArrayList<>();



}
