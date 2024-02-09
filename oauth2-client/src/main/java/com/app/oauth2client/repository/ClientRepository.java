package com.app.oauth2client.repository;

import com.app.oauth2client.model.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientRepository extends JpaRepository <Client, String> {
    boolean existsByEmail(String email);
}
