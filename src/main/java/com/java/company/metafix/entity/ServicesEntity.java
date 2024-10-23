package com.java.company.metafix.entity;


import jakarta.persistence.*;
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
@Entity
public class ServicesEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;
    private Long serviceId;
    private String serviceName;
    private String description;

    @ManyToMany(mappedBy = "servicesList")
    private List<CustomerEntity> customerEntities = new ArrayList<>();
}
