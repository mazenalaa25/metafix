package com.java.company.metafix.repo;

import com.java.company.metafix.entity.ServicesEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ServicesRepoInt extends JpaRepository<ServicesEntity, Long> {
}
