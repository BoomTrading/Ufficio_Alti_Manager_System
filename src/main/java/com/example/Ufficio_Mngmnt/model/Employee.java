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
    @Column(name = "employeeNumber")
    private Integer employeeNumber;

    @Column(name = "lastName")
    private String lastName;

    @Column(name = "firstName")
    private String firstName;

    @Column(name = "email")
    private String email;

    @ManyToOne
    @JoinColumn(name = "officeCode")
    private Office office;

    @ManyToOne
    @JoinColumn(name = "reportsTo")
    private Employee reportsTo;

    @Column(name = "jobTitle")
    private String jobTitle;

}