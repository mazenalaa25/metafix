package com.java.company.metafix.repo;

import com.java.company.metafix.entity.CustomerEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface CustomerRepoInt extends JpaRepository<CustomerEntity , Long> {

    @Query("from CustomerEntity  e where e.FirstName = :FirstName")
    CustomerEntity findByName(String FirstName);

    CustomerEntity findByEmail(String email);

    CustomerEntity findByPassword(String password);
}
