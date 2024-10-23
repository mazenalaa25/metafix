package com.java.company.metafix.service;

import com.java.company.metafix.entity.EmployeeEntity;
import com.java.company.metafix.entity.ServicesEntity;
import com.java.company.metafix.model.EmployeeDto;
import com.java.company.metafix.model.ServicesDto;
import com.java.company.metafix.repo.EmployeeRepoInt;
import com.java.company.metafix.repo.ServicesRepoInt;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
@Service
public class ServicesService implements ServicesServiceInt{
    private final ServicesRepoInt servicesRepoInt;
    private final ModelMapper modelMapper = new ModelMapper();

    public ServicesService(ServicesRepoInt servicesRepoInt) {
        this.servicesRepoInt = servicesRepoInt;
    }

    @Override
    public ServicesDto findByServiceId(Long serviceId) {
        return modelMapper.map(servicesRepoInt.findById(serviceId), ServicesDto.class);
    }

    @Override
    public List<ServicesDto> findAllServices() {
        List<ServicesEntity> servicesEntities = servicesRepoInt.findAll();
        List<ServicesDto> servicesDtos = servicesEntities.stream()
                .map(servicesEntity -> modelMapper.map(servicesEntity,ServicesDto.class))
                .collect(Collectors.toList());
        return servicesDtos;
    }

    @Override
    public ServicesDto addService(ServicesDto servicesDto) {
        ServicesEntity servicesEntity = modelMapper.map(servicesDto, ServicesEntity.class);
        ServicesEntity addServiceEntity = servicesRepoInt.save(servicesEntity);
        return modelMapper.map(addServiceEntity, ServicesDto.class);
    }
}
