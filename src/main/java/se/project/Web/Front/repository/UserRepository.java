package se.project.Web.Front.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import se.project.Web.Front.model.User;


import java.util.UUID;

public interface UserRepository extends JpaRepository<User, UUID> {
    User findByUsername(String username);
}
