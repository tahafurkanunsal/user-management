package tahafurkan.sandbox.usermanagement.entities;

import lombok.*;

import javax.persistence.*;

@Entity(name = "addresses")
@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Address {
    @Id
    @GeneratedValue
    private int id;
    private String addressName;
    private String city;
    private String district;


}
