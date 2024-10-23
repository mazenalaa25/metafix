package com.java.company.metafix.model;

import com.java.company.metafix.entity.CustomerEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class ServicesDto {
    private Long id;
    private Long serviceId;
    private String serviceName;
    private String description;
    private List<CustomerEntity> customerEntities = new ArrayList<>();

}
