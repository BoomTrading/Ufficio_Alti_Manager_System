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
    @Column(name = "office_code")
    private String officeCode;

    @Column(name = "city", nullable = false)
    private String city;

    @Column(name = "phone", nullable = false)
    private String phone;

    @Column(name = "address_line1", nullable = false)
    private String addressLine1;

    @Column(name = "address_line2")
    private String addressLine2;

    @Column(name = "state")
    private String state;

    @Column(name = "country", nullable = false)
    private String country;

    @Column(name = "postal_code", nullable = false)
    private String postalCode;

    @Column(name = "territory", nullable = false)
    private String territory;

    @OneToMany(mappedBy = "office")
    private List<Employee> employees;
}