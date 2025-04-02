package com.example.Ufficio_Mngmnt.controller;

import com.example.Ufficio_Mngmnt.model.AdminUser;
import com.example.Ufficio_Mngmnt.service.AdminUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/adminusers") // Rimosso /api/
public class AdminUserController {

    @Autowired
    private AdminUserService adminUserService;

    // Read (all) - Lista di tutti gli utenti amministrativi
    @GetMapping
    public String getAllAdminUsers(Model model) {
        List<AdminUser> adminUsers = adminUserService.getAllAdminUsers();
        model.addAttribute("adminUsers", adminUsers);
        return "adminusers/list"; // Template: src/main/resources/templates/adminusers/list.html
    }

    // Form per creare un nuovo utente amministrativo
    @GetMapping("/new")
    public String showCreateForm(Model model) {
        model.addAttribute("adminUser", new AdminUser());
        return "adminusers/form"; // Template: src/main/resources/templates/adminusers/form.html
    }

    // Create - Salva un nuovo utente amministrativo
    @PostMapping
    public String createAdminUser(@ModelAttribute AdminUser adminUser) {
        adminUserService.createAdminUser(adminUser);
        return "redirect:/adminusers"; // Reindirizza alla lista
    }

    // Read (by ID) - Dettaglio di un utente (opzionale, se vuoi una vista dettagliata)
    @GetMapping("/{userId}")
    public String getAdminUserById(@PathVariable Integer userId, Model model) {
        AdminUser adminUser = adminUserService.getAdminUserById(userId)
                .orElseThrow(() -> new RuntimeException("AdminUser not found"));
        model.addAttribute("adminUser", adminUser);
        return "adminusers/detail"; // Template: src/main/resources/templates/adminusers/detail.html
    }

    // Form per modificare un utente amministrativo
    @GetMapping("/edit/{userId}")
    public String showEditForm(@PathVariable Integer userId, Model model) {
        AdminUser adminUser = adminUserService.getAdminUserById(userId)
                .orElseThrow(() -> new RuntimeException("AdminUser not found"));
        model.addAttribute("adminUser", adminUser);
        return "adminusers/form";
    }

    // Update - Salva le modifiche a un utente esistente
    @PostMapping("/{userId}")
    public String updateAdminUser(@PathVariable Integer userId, @ModelAttribute AdminUser adminUserDetails) {
        adminUserService.updateAdminUser(userId, adminUserDetails);
        return "redirect:/adminusers";
    }

    // Delete - Elimina un utente amministrativo
    @PostMapping("/delete/{userId}")
    public String deleteAdminUser(@PathVariable Integer userId) {
        adminUserService.deleteAdminUser(userId);
        return "redirect:/adminusers";
    }
}