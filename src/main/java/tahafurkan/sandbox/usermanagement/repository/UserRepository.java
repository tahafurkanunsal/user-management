package tahafurkan.sandbox.usermanagement.repository;

import tahafurkan.sandbox.usermanagement.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {
    boolean existsByUserName(String userName);

    User findByUserName(String userName);
}
