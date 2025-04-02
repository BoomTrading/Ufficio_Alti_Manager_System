package com.example.Ufficio_Mngmnt.service;


import com.example.Ufficio_Mngmnt.model.Employee;
import com.example.Ufficio_Mngmnt.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    public Employee getEmployeeById(Integer id) {
        return employeeRepository.findById(id).orElse(null);
    }

    public List<Employee> getEmployeesByOffice(String officeCode) {
        return employeeRepository.findByOfficeOfficeCode(officeCode);
    }

    public Employee saveEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    public void deleteEmployee(Integer id) {
        employeeRepository.deleteById(id);
    }
}