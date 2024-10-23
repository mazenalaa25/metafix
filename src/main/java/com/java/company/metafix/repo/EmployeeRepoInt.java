package com.java.company.metafix.repo;

import com.java.company.metafix.entity.EmployeeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface EmployeeRepoInt extends JpaRepository<EmployeeEntity , Long> {
    @Query("from EmployeeEntity e where e.FirstName = :FirstName")
    EmployeeEntity findByName(String FirstName);
    EmployeeEntity findByEmail(String email);
    EmployeeEntity findByPassword(String password);
}
