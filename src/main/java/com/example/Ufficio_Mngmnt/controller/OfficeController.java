package com.example.Ufficio_Mngmnt.controller;

import com.example.Ufficio_Mngmnt.model.Office;
import com.example.Ufficio_Mngmnt.service.OfficeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/offices") // Modificato da /api/offices a /offices
public class OfficeController {

    @Autowired
    private OfficeService officeService;

    // Read (all) - Mostra la lista degli uffici
    @GetMapping
    public String getAllOffices(Model model) {
        List<Office> offices = officeService.getAllOffices();
        model.addAttribute("offices", offices);
        return "offices/list"; // Template: src/main/resources/templates/offices/list.html
    }

    // Create - Mostra il form per creare un nuovo ufficio
    @GetMapping("/new")
    public String showCreateForm(Model model) {
        model.addAttribute("office", new Office());
        return "offices/form"; // Template: src/main/resources/templates/offices/form.html
    }

    // Create - Salva il nuovo ufficio
    @PostMapping
    public String createOffice(@ModelAttribute Office office) {
        officeService.createOffice(office);
        return "redirect:/offices"; // Reindirizza alla lista
    }

    // Update - Mostra il form per modificare un ufficio
    @GetMapping("/edit/{officeCode}")
    public String showEditForm(@PathVariable String officeCode, Model model) {
        Office office = officeService.getOfficeById(officeCode)
                .orElseThrow(() -> new RuntimeException("Office not found with code: " + officeCode));
        model.addAttribute("office", office);
        return "offices/form";
    }

    // Update - Salva le modifiche all'ufficio
    @PostMapping("/update/{officeCode}")
    public String updateOffice(@PathVariable String officeCode, @ModelAttribute Office officeDetails) {
        officeService.updateOffice(officeCode, officeDetails);
        return "redirect:/offices"; // Reindirizza alla lista
    }

    // Delete - Elimina un ufficio
    @PostMapping("/delete/{officeCode}")
    public String deleteOffice(@PathVariable String officeCode) {
        officeService.deleteOffice(officeCode);
        return "redirect:/offices"; // Reindirizza alla lista
    }
}