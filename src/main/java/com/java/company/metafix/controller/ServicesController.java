package com.java.company.metafix.controller;

import com.java.company.metafix.model.EmployeeDto;
import com.java.company.metafix.model.ServicesDto;
import com.java.company.metafix.service.ServicesService;
import com.java.company.metafix.service.ServicesServiceInt;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/services")
public class ServicesController {
    public final ServicesServiceInt servicesServiceInt;
    public ServicesController(ServicesServiceInt servicesServiceInt) {
        this.servicesServiceInt = servicesServiceInt;
    }

    @GetMapping
    public List<ServicesDto> findAllServices() {
        return servicesServiceInt.findAllServices();
    }

    @GetMapping("/service")
    public ServicesDto findById(@RequestParam Long serviceId) {
        return servicesServiceInt.findByServiceId(serviceId);
    }

    @PostMapping
    public void addService(@RequestBody ServicesDto servicesDto) {
        servicesServiceInt.addService(servicesDto);
    }

}
