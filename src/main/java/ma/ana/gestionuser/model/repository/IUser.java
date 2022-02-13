package ma.ana.gestionuser.model.repository;

import ma.ana.gestionuser.model.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IUser extends JpaRepository<User, Long> {
}
