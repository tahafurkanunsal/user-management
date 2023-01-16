package tahafurkan.sandbox.usermanagement.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import tahafurkan.sandbox.usermanagement.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Integer> {
    boolean existsByUsername(String username);

    User findByUsername(String username);

    @Query("SELECT u FROM User u JOIN u.address a WHERE a.city = :city")
    List<User> findUsersByGivenCity(@Param("city") String city);
}
