package com.app.oauth2server.repository;

import com.app.oauth2server.model.ClientRoles;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRolesRepository extends JpaRepository <ClientRoles, String> {
}
