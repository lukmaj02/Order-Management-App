package com.app.oauth2server.model;

import com.app.oauth2server.enums.Role;
import jakarta.persistence.*;
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
@Table(name = "_user")
public class User {
    @Id
    @Column(name = "user_id")
    private String userId;
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private boolean enabled;

    @OneToMany(mappedBy = "role", orphanRemoval = true, fetch = FetchType.EAGER)
    private Set<Role> roles;
}
