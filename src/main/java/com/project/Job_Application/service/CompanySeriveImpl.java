package com.project.Job_Application.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.project.Job_Application.entity.Company;
import com.project.Job_Application.entity.Job;
import com.project.Job_Application.repository.CompanyRepository;
@Service
public class CompanySeriveImpl implements CompanySerive {

private CompanyRepository companyRepository;

    public CompanySeriveImpl(CompanyRepository companyRepository) {
    this.companyRepository = companyRepository;
}

    @Override
    public List<Company> getAllCompanies() {
        // TODO Auto-generated method stub
return companyRepository.findAll();
    }

    @Override
    public boolean updateCompany(Company company, Long id) {
        Optional<Company> companyOptional=companyRepository.findById(id);
        if(companyOptional.isPresent()){
            Company companyToUpdate =companyOptional.get();
            companyToUpdate.setDescription(company.getDescription());
            companyToUpdate.setName(company.getName());
            companyToUpdate.setJobs(company.getJobs());
            companyRepository.save(companyToUpdate);
            return true;

        }else{
            return false;
        }

    }

    @Override
    public void createCompany(Company company) {
        // TODO Auto-generated method stub
        companyRepository.save(company);
        
    }

    @Override
    public boolean deleteCompanyById(Long id) {
        // TODO Auto-generated method stub
       if(companyRepository.existsById(id)){
        companyRepository.deleteById(id);
        return true;
       }else{
        return false; 
       }

    }

    @Override
    public Company getCompanyById(Long id) {
        // TODO Auto-generated method stub
        return companyRepository.findById(id).orElse(null);
        
    }

 

}
