package com.app.oauth2server.repository;

import com.app.oauth2server.model.UserRoles;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRolesRepository extends JpaRepository <UserRoles, String> {
}
