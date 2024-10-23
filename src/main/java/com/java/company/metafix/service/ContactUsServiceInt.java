package com.java.company.metafix.service;

import com.java.company.metafix.entity.ContactUsEntity;
import com.java.company.metafix.model.ContactUsDto;

import java.util.List;

public interface ContactUsServiceInt {
    void sendMessage(ContactUsDto contactUsDto);
    List<ContactUsDto> getContactUsList();
    void deleteContactUsById(Long id);
}
