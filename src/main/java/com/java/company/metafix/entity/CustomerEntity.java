package com.java.company.metafix.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class CustomerEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String FirstName;
    private String LastName;
    private String email;
    private String password;
    private String phone;
    private String address;

    @ManyToMany
    @JoinTable(
            name = "Customer_Services"
            , joinColumns = @JoinColumn(name = "Customer_id")
            , inverseJoinColumns = @JoinColumn(name = "Service_id")
    )
    private List<ServicesEntity> servicesList;


}
