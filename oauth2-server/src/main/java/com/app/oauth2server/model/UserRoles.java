package com.app.oauth2server.model;

import com.app.oauth2server.enums.Role;
import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "_user_roles")
public class UserRoles {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    @Enumerated(EnumType.STRING)
    private Role role;

    @ManyToOne
    @JoinColumn(name = "user_id",referencedColumnName = "user_id")
    private User user;

}
