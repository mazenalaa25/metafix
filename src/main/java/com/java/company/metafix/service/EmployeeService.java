package com.java.company.metafix.service;

import com.java.company.metafix.entity.EmployeeEntity;
import com.java.company.metafix.model.EmployeeDto;
import com.java.company.metafix.repo.EmployeeRepoInt;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
 @Service
public class EmployeeService implements EmployeeServiceInt {

    private final EmployeeRepoInt employeeRepoInt;
    private final ModelMapper modelMapper = new ModelMapper();

    public EmployeeService(EmployeeRepoInt employeeRepoInt) {
        this.employeeRepoInt = employeeRepoInt;
    }

    @Override
    public EmployeeDto findById(Long id) {
        return modelMapper.map(employeeRepoInt.findById(id), EmployeeDto.class);
    }

    @Override
    public EmployeeDto findByName(String FirstName) {
        EmployeeEntity employeeName = employeeRepoInt.findByName(FirstName);
               //lazem a3mel optonal fe el repo 34an a3mel run time Exception
              //  .orElseThrow(() -> new RuntimeException("Employee not found"));
        return modelMapper.map(employeeName, EmployeeDto.class);
    }

    @Override
    public boolean findByEmail(String email) {

        EmployeeEntity employeeEmail = employeeRepoInt.findByEmail(email);
        if (employeeEmail != null) {
            return true;
        }
        else {
            return false;
        }
    }

    @Override
    public boolean findByPassword(String password) {
        EmployeeEntity employeePassword = employeeRepoInt.findByPassword(password);
        if (employeePassword != null) {
            return true;
        }else {
        return false;}
    }

    @Override
    public List<EmployeeDto> findAllEmployees() {
       List<EmployeeEntity> employeeEntities = employeeRepoInt.findAll();
      List<EmployeeDto> employeeDtos = employeeEntities.stream()
              .map(employeeEntity -> modelMapper.map(employeeEntity,EmployeeDto.class))
              .collect(Collectors.toList());
        return employeeDtos;
    }

    @Override
    public EmployeeDto addEmployee(EmployeeDto employeeDto) {
       EmployeeEntity employeeEntity = modelMapper.map(employeeDto, EmployeeEntity.class);
       EmployeeEntity addEmployeeEntity = employeeRepoInt.save(employeeEntity);


        return modelMapper.map(addEmployeeEntity,EmployeeDto.class);
    }

    @Override
    public EmployeeDto updateEmployee(EmployeeDto employeeDto) {
        EmployeeEntity employeeEntity = modelMapper.map(employeeDto, EmployeeEntity.class);
        EmployeeEntity saveEmployeeEntity = employeeRepoInt.save(employeeEntity);


        return modelMapper.map(saveEmployeeEntity,EmployeeDto.class);

    }


    @Override
    public EmployeeDto patchUpdateEmployee(EmployeeDto employeeDto) {
        return null;
    }

    @Override
     public void deleteEmployee(Long id) {
         employeeRepoInt.deleteById(id);

     }
}
