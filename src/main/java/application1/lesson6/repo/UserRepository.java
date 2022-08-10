package application1.lesson6.repo;

import application1.lesson6.data.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.*;


@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    @Query("SELECT u FROM User u WHERE u.username like concat('%', :name, '%') ")
    Optional<User> findByUsername(String name);

    User getUserById(Long Id);
}
