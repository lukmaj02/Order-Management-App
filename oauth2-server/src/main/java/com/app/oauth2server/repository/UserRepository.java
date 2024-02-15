package com.app.oauth2server.repository;

import com.app.oauth2server.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository <User, String> {
    Optional<User> findByEmail(String email);
}
