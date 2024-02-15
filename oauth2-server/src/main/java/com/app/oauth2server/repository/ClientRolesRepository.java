package com.app.oauth2server.repository;

import com.app.oauth2server.model.UserRoles;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRolesRepository extends JpaRepository <UserRoles, String> {
}
