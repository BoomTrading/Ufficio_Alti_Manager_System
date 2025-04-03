package com.example.Ufficio_Mngmnt.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.Ufficio_Mngmnt.model.AdminUser;

@Service
public class CustomUserDetailsService implements UserDetailsService {

   @Autowired
private final AdminUserService adminUserService;

public CustomUserDetailsService(AdminUserService adminUserService) {
    this.adminUserService = adminUserService;
}

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        AdminUser admin = adminUserService.findByUsername(username);
        if (admin == null) {
            throw new UsernameNotFoundException("Utente non trovato: " + username);
        }

        // Costruzione dell'oggetto UserDetails con password criptata
        return org.springframework.security.core.userdetails.User
            .builder()
            .username(admin.getUsername())
            .password(admin.getPassword()) // Password già criptata
            .roles("USER") // Ruolo predefinito
            .build();
    }
}