package ucentral.edu.co.mikaza.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ucentral.edu.co.mikaza.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    User findByVerificationCode(String code);
    User findByEmail(String email);
    boolean existsByEmail(String email);
    boolean existsByDocumentNumber(String documentNumber);
}
