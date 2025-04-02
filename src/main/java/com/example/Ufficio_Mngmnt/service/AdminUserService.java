package com.example.Ufficio_Mngmnt.service;


import com.example.Ufficio_Mngmnt.model.AdminUser;
import com.example.Ufficio_Mngmnt.repository.AdminUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AdminUserService {

    @Autowired
    private AdminUserRepository adminUserRepository;

    // Create
    public AdminUser createAdminUser(AdminUser adminUser) {
        return adminUserRepository.save(adminUser);
    }

    // Read (all)
    public List<AdminUser> getAllAdminUsers() {
        return adminUserRepository.findAll();
    }

    // Read (by ID)
    public Optional<AdminUser> getAdminUserById(Integer userId) {
        return adminUserRepository.findById(userId);
    }

    // Read (by username)
    public AdminUser getAdminUserByUsername(String username) {
        return adminUserRepository.findByUsername(username);
    }

    // Update
    public AdminUser updateAdminUser(Integer userId, AdminUser adminUserDetails) {
        AdminUser adminUser = adminUserRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("AdminUser not found with id: " + userId));
        adminUser.setUsername(adminUserDetails.getUsername());
        adminUser.setPassword(adminUserDetails.getPassword());
        adminUser.setEmail(adminUserDetails.getEmail());
        adminUser.setRole(adminUserDetails.getRole());
        adminUser.setLastLogin(adminUserDetails.getLastLogin());
        return adminUserRepository.save(adminUser);
    }

    // Delete
    public void deleteAdminUser(Integer userId) {
        adminUserRepository.deleteById(userId);
    }
}