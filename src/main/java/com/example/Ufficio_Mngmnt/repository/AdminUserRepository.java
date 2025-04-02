package com.example.Ufficio_Mngmnt.repository;

import com.example.Ufficio_Mngmnt.model.AdminUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdminUserRepository extends JpaRepository<AdminUser, Integer> {
    // Metodi personalizzati
    AdminUser findByUsername(String username);
    
    AdminUser findByEmail(String email);
}