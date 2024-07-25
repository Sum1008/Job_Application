package com.project.Job_Application.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.Job_Application.entity.Company;
@Repository
public interface CompanyRepository extends JpaRepository<Company,Long> {

}
