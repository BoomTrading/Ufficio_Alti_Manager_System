package com.example.Ufficio_Mngmnt.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;


@Data 
@NoArgsConstructor
@AllArgsConstructor

@Entity
@Table(name = "offices")
public class Office {

    @Id
    @Column(name = "officeCode")
    private String officeCode;

    @Column(name = "city")
    private String city;

    @Column(name = "phone")
    private String phone;

    @Column(name = "addressLine1")
    private String addressLine1;

    @Column(name = "addressLine2")
    private String addressLine2;

    @Column(name = "state")
    private String state;

    @Column(name = "country")
    private String country;

    @Column(name = "postalCode")
    private String postalCode;

    @Column(name = "territory")
    private String territory;

    @OneToMany(mappedBy = "office")
    private List<Employee> employees;
}