package com.java.company.metafix.service;

import com.java.company.metafix.model.EmployeeDto;

import java.util.List;

public interface EmployeeServiceInt {

    EmployeeDto findById(Long id);
    EmployeeDto findByName(String FirstName);
    boolean findByEmail(String email);
    boolean findByPassword(String password);
     List<EmployeeDto> findAllEmployees();
     EmployeeDto addEmployee(EmployeeDto employeeDto);
     EmployeeDto updateEmployee(EmployeeDto employeeDto);
    void deleteEmployee(Long id);
    EmployeeDto patchUpdateEmployee(EmployeeDto employeeDto);


}
