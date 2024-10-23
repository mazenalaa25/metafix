package com.java.company.metafix.service;

import com.java.company.metafix.model.CustomerDto;

import java.util.List;

public interface CustomerServiceInt {
    CustomerDto findById(Long id);
   CustomerDto findByName(String FirstName);
    boolean findByEmail(String email);
    boolean findByPassword(String password);
    List<CustomerDto> findAll();
    CustomerDto addCustomer(CustomerDto customerDto);
    void deleteById(Long id);
    CustomerDto updateCustomer(CustomerDto customerDto);
    CustomerDto patchUpdateCustomer(CustomerDto customerDto);


}
