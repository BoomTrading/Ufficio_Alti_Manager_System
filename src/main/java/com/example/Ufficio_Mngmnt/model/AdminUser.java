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
    @Column(name = "userId")
    private Integer userId;

    @Column(name = "username")
    private String username;

    @Column(name = "password")
    private String password;

    @Column(name = "email")
    private String email;

    @Enumerated(EnumType.STRING)
    @Column(name = "role")
    private Role role;

    @Column(name = "createdAt")
    private LocalDateTime createdAt;

    @Column(name = "lastLogin")
    private LocalDateTime lastLogin;

    // Enum per il campo role
    public enum Role {
        USER, MANAGER, ADMIN
    }

}