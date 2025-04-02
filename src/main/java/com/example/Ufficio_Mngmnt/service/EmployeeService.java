package com.example.Ufficio_Mngmnt.service;


import com.example.Ufficio_Mngmnt.model.Employee;
import com.example.Ufficio_Mngmnt.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    // Create
    public Employee createEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    // Read (all)
    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    // Read (by ID)
    public Optional<Employee> getEmployeeById(Integer employeeNumber) {
        return employeeRepository.findById(employeeNumber);
    }

    // Read (by office code)
    public List<Employee> getEmployeesByOfficeCode(String officeCode) {
        return employeeRepository.findByOfficeOfficeCode(officeCode);
    }

    // Update
    public Employee updateEmployee(Integer employeeNumber, Employee employeeDetails) {
        Employee employee = employeeRepository.findById(employeeNumber)
                .orElseThrow(() -> new RuntimeException("Employee not found with number: " + employeeNumber));
        employee.setLastName(employeeDetails.getLastName());
        employee.setFirstName(employeeDetails.getFirstName());
        employee.setEmail(employeeDetails.getEmail());
        employee.setOffice(employeeDetails.getOffice());
        employee.setReportsTo(employeeDetails.getReportsTo());
        employee.setJobTitle(employeeDetails.getJobTitle());
        return employeeRepository.save(employee);
    }

    // Delete
    public void deleteEmployee(Integer employeeNumber) {
        employeeRepository.deleteById(employeeNumber);
    }
}