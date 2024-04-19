package ma.fsm.jpafsm.repositories;

import ma.fsm.jpafsm.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, String> {
    User findByUsername(String username);
}
