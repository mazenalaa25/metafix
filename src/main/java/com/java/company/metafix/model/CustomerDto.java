package com.java.company.metafix.model;

import com.java.company.metafix.entity.ServicesEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor

public class CustomerDto {
    private Long id;
    private String FirstName;
    private String LastName;
    private String email;
    private String password;
    private String phone;
    private String address;
    private List<ServicesEntity> servicesList;

}
