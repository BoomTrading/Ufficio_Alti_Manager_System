package com.example.Ufficio_Mngmnt.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "admusers")
public class AdminUser {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Integer userId; // Mappa a user_id

    @Column(name = "username", nullable = false, unique = true, length = 50)
    private String username; // Mappa a username

    @Column(name = "password", nullable = false, length = 255)
    private String password; // Mappa a password

    @Column(name = "email", nullable = false, unique = true, length = 100)
    private String email; // Mappa a email

    @Enumerated(EnumType.STRING)
    @Column(name = "role", nullable = false)
    private Role role; // Mappa a role

    @Column(name = "created_at")
    private LocalDateTime createdAt; // Mappa a created_at

    @Column(name = "last_login")
    private LocalDateTime lastLogin; // Mappa a last_login

    public enum Role {
        USER, MANAGER, ADMIN
    }

    
}