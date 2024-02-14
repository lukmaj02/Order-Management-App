package com.app.oauth2server.model;

import com.app.oauth2server.enums.Role;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Client {
    @Id
    private String id;
    private String email;
    private String password;
    private boolean enabled;

    @OneToMany(mappedBy = "role", orphanRemoval = true, fetch = FetchType.EAGER)
    private Set<Role> roles;
}
