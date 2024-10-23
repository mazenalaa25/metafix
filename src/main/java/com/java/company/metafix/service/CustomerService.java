package com.java.company.metafix.service;

import com.java.company.metafix.entity.CustomerEntity;
import com.java.company.metafix.model.CustomerDto;
import com.java.company.metafix.repo.CustomerRepoInt;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.stream.Collectors;

@Service
public class CustomerService implements CustomerServiceInt{

    private final CustomerRepoInt customerRepoInt;
    private final ModelMapper modelMapper = new ModelMapper();
    public CustomerService(CustomerRepoInt customerRepoInt) {
        this.customerRepoInt = customerRepoInt;
    }


    @Override
    public CustomerDto findById(Long id) {

        return modelMapper.map(customerRepoInt.findById(id), CustomerDto.class);
    }

  @Override
    public CustomerDto findByName(String FirstName) {
        CustomerEntity customerName = customerRepoInt.findByName(FirstName);
        return modelMapper.map(customerName, CustomerDto.class);
    }

    @Override
    public boolean findByEmail(String email) {
        CustomerEntity customerEmail = customerRepoInt.findByEmail(email);
        if (customerEmail != null) {
            return true;
        }
        else {
            return false;
        }
    }

    @Override
    public boolean findByPassword(String password) {
        CustomerEntity customerPassword = customerRepoInt.findByPassword(password);
        if (customerPassword != null) {
            return true;
        }else {
            return false;
        }
    }

    @Override
    public List<CustomerDto> findAll() {
       List<CustomerEntity> customerEntities = customerRepoInt.findAll();
       List<CustomerDto> customerDtos = customerEntities.stream()
               .map(customerEntity -> modelMapper.map(customerEntity,CustomerDto.class))
               .collect(Collectors.toList());

        return customerDtos;
    }

    @Override
    public CustomerDto addCustomer(CustomerDto customerDto) {
        CustomerEntity customerEntity = modelMapper.map(customerDto, CustomerEntity.class);
        CustomerEntity addCustomerEntity = customerRepoInt.save(customerEntity);

        return modelMapper.map(addCustomerEntity,CustomerDto.class);
    }



    @Override
    public CustomerDto updateCustomer(CustomerDto customerDto) {
        CustomerEntity customerEntity = modelMapper.map(customerDto, CustomerEntity.class);
        CustomerEntity saveCustomerEntity = customerRepoInt.save(customerEntity);

        return modelMapper.map(saveCustomerEntity,CustomerDto.class);

    }

    @Override
    public CustomerDto patchUpdateCustomer(CustomerDto customerDto) {
        CustomerEntity customerEntity = modelMapper.map(customerDto, CustomerEntity.class);
        CustomerEntity oldCustomer = customerRepoInt.findById(customerDto.getId()).get();
        if(customerEntity != null) {

            if(customerEntity.getFirstName()!=null)
                oldCustomer.setFirstName(customerEntity.getFirstName());

            if(customerEntity.getLastName()!=null)
                oldCustomer.setLastName(customerEntity.getLastName());

            if(customerEntity.getPassword()!=null)
                oldCustomer.setPassword(customerEntity.getPassword());

            if(customerEntity.getPhone()!=null)
                oldCustomer.setPhone(customerEntity.getPhone());


        }
        CustomerEntity savedCustomerEntity = customerRepoInt.save(oldCustomer);
        return modelMapper.map(savedCustomerEntity, CustomerDto.class);

    }

    @Override
    public void deleteById(Long id) {

        customerRepoInt.deleteById(id);
    }
}
