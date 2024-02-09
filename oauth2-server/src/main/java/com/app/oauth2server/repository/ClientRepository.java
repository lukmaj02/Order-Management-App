package com.app.oauth2server.repository;

import com.app.oauth2server.model.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface ClientRepository extends JpaRepository <Client, String> {
    Optional<Client> findByEmail(String email);
}
