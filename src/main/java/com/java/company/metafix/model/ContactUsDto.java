package com.java.company.metafix.model;

import com.java.company.metafix.entity.CustomerEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor

public class ContactUsDto {
    private Long id;
    private String type;
    private String content;
    private CustomerEntity customer;
}
