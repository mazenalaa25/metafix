package com.java.company.metafix.controller;

import com.java.company.metafix.model.EmployeeDto;
import com.java.company.metafix.service.EmployeeService;
import com.java.company.metafix.service.EmployeeServiceInt;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Employee")
public class EmployeeController {

    public final EmployeeServiceInt employeeService;
    public EmployeeController(EmployeeServiceInt employeeService) {
        this.employeeService = employeeService;
    }


    @GetMapping("/findall")
    public List<EmployeeDto> findAllEmployees() {
        return employeeService.findAllEmployees();
    }

    @GetMapping("/findById")
    public EmployeeDto findById(@RequestParam Long id) {
        return employeeService.findById(id);
    }

    @GetMapping("/findByName")
    public EmployeeDto findByName(@RequestParam String FirstName) {
        return employeeService.findByName(FirstName);


    }

    @PostMapping
    public EmployeeDto SignupSumbit(@RequestBody EmployeeDto employeeDto) {
        return employeeService.addEmployee(employeeDto);


    }
    @PutMapping
    public EmployeeDto updateEmployee(@RequestParam EmployeeDto employeeDto) {
        return employeeService.updateEmployee(employeeDto);

    }


    @PatchMapping
    public EmployeeDto patchEmployee(@RequestBody EmployeeDto employeeDto) {
        return employeeService.updateEmployee(employeeDto);
    }

    /*@GetMapping("login")
    public String loginSumbit(@RequestBody EmployeeDto employeeDto) {
        Boolean email = employeeService.findByEmail(employeeDto.getEmail());
        Boolean password = employeeService.findByPassword(employeeDto.getPassword());
        if (email && password) {
            return employeeDto.getEmail();

        }
        else {
            return null;
        }


    }*/

    @DeleteMapping
    public void deleteEmployee(@RequestParam Long id) {
        employeeService.deleteEmployee(id);
    }

}
