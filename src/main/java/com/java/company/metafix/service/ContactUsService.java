package com.java.company.metafix.service;

import com.java.company.metafix.entity.ContactUsEntity;
import com.java.company.metafix.model.ContactUsDto;
import com.java.company.metafix.repo.ContactUsRepoInt;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ContactUsService implements ContactUsServiceInt {
    private  final ContactUsRepoInt contactUsRepo;
    private final ModelMapper modelMapper =new ModelMapper();

    public ContactUsService(ContactUsRepoInt contactUsRepo) {
        this.contactUsRepo = contactUsRepo;
    }


    @Override
    public void sendMessage(ContactUsDto contactUsDto) {
        ContactUsEntity contactUsEntity = modelMapper.map(contactUsDto, ContactUsEntity.class);
        ContactUsEntity saveMessage = contactUsRepo.save(contactUsEntity);


//        contactUsRepo.save(modelMapper.map(contactUsDto, ContactUsEntity.class));

    }


    @Override
    public List<ContactUsDto> getContactUsList() {
        List<ContactUsEntity> contactUsEntities = contactUsRepo.findAll();
        List<ContactUsDto> contactUsDtos = contactUsEntities.stream().map(contactUsEntity -> modelMapper.map(contactUsEntity,ContactUsDto.class)).collect(Collectors.toList());
        return contactUsDtos;
    }

    @Override
    public void deleteContactUsById(Long id) {
        contactUsRepo.deleteById(id);
    }


}
