package com.example.Ufficio_Mngmnt.controller;

import com.example.Ufficio_Mngmnt.model.Office;
import com.example.Ufficio_Mngmnt.service.OfficeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/offices")
public class OfficeController {

    @Autowired
    private OfficeService officeService;

    // Read (all) - Show office list with optional search
    @GetMapping
    public String getAllOffices(Model model, @RequestParam(required = false) String search,
                               @RequestParam(required = false) String filter,
                               @RequestParam(required = false) String value) {
        List<Office> offices;
        
        if (search != null && !search.isEmpty()) {
            // General search
            offices = officeService.searchOffices(search);
            model.addAttribute("search", search);
        } else if (filter != null && value != null && !value.isEmpty()) {
            // Filter by specific field
            switch (filter) {
                case "city":
                    offices = officeService.findByCity(value);
                    break;
                case "country":
                    offices = officeService.findByCountry(value);
                    break;
                case "territory":
                    offices = officeService.findByTerritory(value);
                    break;
                default:
                    offices = officeService.getAllOffices();
            }
            model.addAttribute("filter", filter);
            model.addAttribute("value", value);
        } else {
            // No search or filter, get all
            offices = officeService.getAllOffices();
        }
        
        model.addAttribute("offices", offices);
        return "offices/list";
    }

    // Create - Show form for creating a new office
    @GetMapping("/new")
    public String showCreateForm(Model model) {
        model.addAttribute("office", new Office());
        return "offices/form";
    }

    // Create - Save the new office
    @PostMapping
    public String createOffice(@ModelAttribute Office office) {
        officeService.createOffice(office);
        return "redirect:/offices";
    }

    // Update - Show form for editing an office
    @GetMapping("/edit/{officeCode}")
    public String showEditForm(@PathVariable String officeCode, Model model) {
        Office office = officeService.getOfficeById(officeCode)
                .orElseThrow(() -> new RuntimeException("Office not found with code: " + officeCode));
        model.addAttribute("office", office);
        return "offices/form";
    }

    // Update - Save changes to an office
    @PostMapping("/update/{officeCode}")
    public String updateOffice(@PathVariable String officeCode, @ModelAttribute Office officeDetails) {
        officeService.updateOffice(officeCode, officeDetails);
        return "redirect:/offices";
    }

    // Delete - Delete an office
    @PostMapping("/delete/{officeCode}")
    public String deleteOffice(@PathVariable String officeCode) {
        officeService.deleteOffice(officeCode);
        return "redirect:/offices";
    }
}