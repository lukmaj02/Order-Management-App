package com.app.oauth2client.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Client {
    @Id
    private String id;
    private String email;
    private String password;
    private String role;
    private boolean enabled;
}
