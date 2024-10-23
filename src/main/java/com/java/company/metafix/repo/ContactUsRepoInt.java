package com.java.company.metafix.repo;

import com.java.company.metafix.entity.ContactUsEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContactUsRepoInt extends JpaRepository<ContactUsEntity,Long> {
}
