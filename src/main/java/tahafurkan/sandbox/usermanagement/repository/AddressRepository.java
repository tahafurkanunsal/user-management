package tahafurkan.sandbox.usermanagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import tahafurkan.sandbox.usermanagement.entities.Address;
import tahafurkan.sandbox.usermanagement.entities.User;

import java.util.List;

public interface AddressRepository extends JpaRepository<Address, Integer> {
    @Query("SELECT u FROM User u JOIN u.address a WHERE a.city = :city")
    List<User> findUsersByGivenCity(@Param("city") String city);
}
