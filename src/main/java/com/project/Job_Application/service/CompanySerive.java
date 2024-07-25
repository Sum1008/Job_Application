package com.project.Job_Application.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.project.Job_Application.entity.Company;

public interface CompanySerive {

    List<Company> getAllCompanies();

    boolean updateCompany(Company company, Long id);

    void createCompany(Company company);

    boolean deleteCompanyById(Long id);

    Company getCompanyById(Long id);
    

}
