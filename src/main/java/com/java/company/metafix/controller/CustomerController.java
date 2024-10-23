package com.java.company.metafix.controller;

import com.java.company.metafix.model.CustomerDto;
import com.java.company.metafix.service.CustomerService;
import com.java.company.metafix.service.CustomerServiceInt;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/Customer")
public class CustomerController {

    private final CustomerServiceInt customerService;
    public CustomerController(CustomerServiceInt customerService) {
        this.customerService = customerService;
    }

    @GetMapping("/findall")
    public List<CustomerDto> findAll(){
        return customerService.findAll();
    }

    @GetMapping("/findById")
    public CustomerDto findById(@RequestParam Long id){
        return customerService.findById(id);
    }

   @GetMapping("/findbyName")
    public CustomerDto findByName(@RequestParam String FirstName){
        return customerService.findByName(FirstName);
    }

    @PostMapping
    public CustomerDto SignupSumbit(@RequestBody CustomerDto customerDto){
        return customerService.addCustomer(customerDto) ;
    }
    @PutMapping
    public CustomerDto Update(@RequestBody CustomerDto customerDto){
        return customerService.updateCustomer(customerDto) ;
    }

   @GetMapping("/Login")
    public String loginSumbit(@RequestBody CustomerDto customerDto){
        Boolean email = customerService.findByEmail(customerDto.getEmail());
        Boolean password = customerService.findByPassword(customerDto.getPassword());
        if(email && password){
            return customerDto.getEmail();

        }
        else {return null;}

    }


    @PatchMapping
    public CustomerDto  patchUpdateCustomer(@RequestBody CustomerDto customerDto){
        return customerService.patchUpdateCustomer(customerDto) ;
    }

    @DeleteMapping
    public void delete(@RequestParam Long id){
         customerService.deleteById(id);
    }



}
