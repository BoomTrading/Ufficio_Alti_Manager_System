package com.example.Ufficio_Mngmnt.controller;

import com.example.Ufficio_Mngmnt.model.Employee;
import com.example.Ufficio_Mngmnt.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/employees")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    // Read (all) - Lista di tutti i dipendenti
    @GetMapping
    public String getAllEmployees(Model model) {
        List<Employee> employees = employeeService.getAllEmployees();
        model.addAttribute("employees", employees);
        return "employees/list"; // Template: src/main/resources/templates/employees/list.html
    }

    // Read (by ID) - Dettaglio di un dipendente
    @GetMapping("/{employeeNumber}")
    public String getEmployeeById(@PathVariable Integer employeeNumber, Model model) {
        Employee employee = employeeService.getEmployeeById(employeeNumber)
                .orElseThrow(() -> new RuntimeException("Employee not found"));
        model.addAttribute("employee", employee);
        return "employees/detail"; // Template: src/main/resources/templates/employees/detail.html
    }

    // Read (by office code) - Lista dipendenti per ufficio
    @GetMapping("/office/{officeCode}")
    public String getEmployeesByOfficeCode(@PathVariable String officeCode, Model model) {
        List<Employee> employees = employeeService.getEmployeesByOfficeCode(officeCode);
        model.addAttribute("employees", employees);
        model.addAttribute("officeCode", officeCode);
        return "employees/list"; // Riutilizza il template della lista
    }

    // Create - Mostra form per nuovo dipendente
    @GetMapping("/new")
    public String showCreateForm(Model model) {
        model.addAttribute("employee", new Employee());
        return "employees/form"; // Template: src/main/resources/templates/employees/form.html
    }

    // Create - Salva nuovo dipendente
    @PostMapping
    public String createEmployee(@ModelAttribute Employee employee) {
        employeeService.createEmployee(employee);
        return "redirect:/employees"; // Reindirizza alla lista
    }

    // Update - Mostra form per modificare dipendente
    @GetMapping("/edit/{employeeNumber}")
    public String showEditForm(@PathVariable Integer employeeNumber, Model model) {
        Employee employee = employeeService.getEmployeeById(employeeNumber)
                .orElseThrow(() -> new RuntimeException("Employee not found"));
        model.addAttribute("employee", employee);
        return "employees/form"; // Riutilizza il form per creazione/modifica
    }

    // Update - Salva modifiche dipendente
    @PostMapping("/{employeeNumber}")
    public String updateEmployee(@PathVariable Integer employeeNumber, @ModelAttribute Employee employeeDetails) {
        employeeService.updateEmployee(employeeNumber, employeeDetails);
        return "redirect:/employees"; // Reindirizza alla lista
    }

    // Delete - Elimina dipendente
    @PostMapping("/delete/{employeeNumber}")
    public String deleteEmployee(@PathVariable Integer employeeNumber) {
        employeeService.deleteEmployee(employeeNumber);
        return "redirect:/employees"; // Reindirizza alla lista
    }
}