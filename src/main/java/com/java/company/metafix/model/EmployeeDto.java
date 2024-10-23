package com.java.company.metafix.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor

public class EmployeeDto {
    private Long id;
    private String FirstName;
    private String LastName;
    private String email;
    private String password;
    private String phone;
    private String jobTitle;

}
