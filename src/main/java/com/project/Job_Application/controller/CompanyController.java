package com.project.Job_Application.controller;

import org.springframework.web.bind.annotation.RestController;

import com.project.Job_Application.entity.Company;
import com.project.Job_Application.service.CompanySerive;

import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;



@RestController
@RequestMapping("/companies")

public class CompanyController {

    private CompanySerive companySerive;

    public CompanyController(CompanySerive companySerive) {
        this.companySerive = companySerive;
    }
    
    @GetMapping()
    public ResponseEntity<List<Company>>getALlCompanies(){
        return new ResponseEntity<>(companySerive.getAllCompanies(),HttpStatus.OK);
    }
    

    @PutMapping("/{id}")
    public ResponseEntity<String> updateCompany(@PathVariable Long id,@RequestBody Company company){
        companySerive.updateCompany(company, id);
        return new ResponseEntity<>("Company updated successfully",HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<String> addcompany(@RequestBody Company company){
        companySerive.createCompany(company);
        return new ResponseEntity<>("Company added successfully",HttpStatus.CREATED);

    }
@DeleteMapping("/{id}")
    public ResponseEntity<String> deleteCompany(@PathVariable Long id){
        boolean isDeleted=companySerive.deleteCompanyById(id);
        if(isDeleted){
            return new ResponseEntity<>("company successfully deleted",HttpStatus.OK);
        }
        else{
            return new ResponseEntity<>("company not found",HttpStatus.NOT_FOUND);
        }
    } 


    @GetMapping("/{id}")
    public ResponseEntity<Company> getCompany(@PathVariable Long id){
        Company company =companySerive.getCompanyById(id);
        if(company!= null){
            return new ResponseEntity<>(company,HttpStatus.OK);
        
        }else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);

        }

    }
}
