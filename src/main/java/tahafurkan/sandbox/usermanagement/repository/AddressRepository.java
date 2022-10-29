package tahafurkan.sandbox.usermanagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tahafurkan.sandbox.usermanagement.entities.Address;

public interface AddressRepository extends JpaRepository<Address, Integer> {
}
