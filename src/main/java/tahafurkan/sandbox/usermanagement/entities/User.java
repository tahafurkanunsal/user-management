package tahafurkan.sandbox.usermanagement.entities;


import lombok.*;

import javax.persistence.*;
import java.util.List;


@Entity
@Table(name = "User")
@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class User {
    @Id
    @GeneratedValue
    private int id;
    private String name;
    private String lastName;
    private String email;
    @Column(unique = true)
    private String username;
    @OneToMany(targetEntity = Address.class, cascade = CascadeType.ALL)
    @JoinColumn(referencedColumnName = "id")
    private List<Address> address;

}
