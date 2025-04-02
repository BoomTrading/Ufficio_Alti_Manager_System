package com.example.Ufficio_Mngmnt.repository;


import com.example.Ufficio_Mngmnt.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
    // Metodi personalizzati
    List<Employee> findByLastNameAndFirstName(String lastName, String firstName);
    
    List<Employee> findByOfficeOfficeCode(String officeCode);
    
    @Query("SELECT e FROM Employee e WHERE e.reportsTo.employeeNumber = :managerId")
    List<Employee> findByReportsToId(Integer managerId);
}