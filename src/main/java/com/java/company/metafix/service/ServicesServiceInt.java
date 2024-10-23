package com.java.company.metafix.service;

import com.java.company.metafix.model.ServicesDto;

import java.util.List;

public interface ServicesServiceInt {
    ServicesDto findByServiceId(Long serviceId);
    List<ServicesDto> findAllServices();
    ServicesDto addService(ServicesDto servicesDto);
}
