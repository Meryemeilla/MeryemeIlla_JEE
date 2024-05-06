package ma.fsm.hopital.security.repo;

import ma.fsm.hopital.security.entities.AppRole;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AppRoleRepository extends JpaRepository<AppRole, String> {

}
