package com.example.Ufficio_Mngmnt.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data 
@NoArgsConstructor
@AllArgsConstructor

@Entity
@Table(name = "employees")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "employee_number")
    private Integer employeeNumber;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "email")
    private String email;

    @ManyToOne
    @JoinColumn(name = "office_code")
    private Office office;

    @ManyToOne
    @JoinColumn(name = "reports_to")
    private Employee reportsTo;

    @Column(name = "job_title")
    private String jobTitle;

}