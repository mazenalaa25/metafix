package com.java.company.metafix.controller;

import com.java.company.metafix.model.ContactUsDto;
import com.java.company.metafix.service.ContactUsService;
import com.java.company.metafix.service.ContactUsServiceInt;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ContactUs")
public class ContactUsController {
    public final ContactUsServiceInt contactUsServiceInt;

    public ContactUsController(ContactUsServiceInt contactUsServiceInt) {
        this.contactUsServiceInt = contactUsServiceInt;
    }

    @PostMapping
    public void sendMessage(@RequestBody ContactUsDto contactUsDto) {
        contactUsServiceInt.sendMessage(contactUsDto);

    }
    @GetMapping("/getall")
    public List<ContactUsDto> getContactUs() {

        return contactUsServiceInt.getContactUsList();

    }

    @DeleteMapping
    public void deleteMessage(@RequestParam Long id) {
        contactUsServiceInt.deleteContactUsById(id);
    }
}
