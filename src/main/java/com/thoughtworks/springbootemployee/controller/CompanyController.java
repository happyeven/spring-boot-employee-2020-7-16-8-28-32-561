package com.thoughtworks.springbootemployee.controller;


import com.thoughtworks.springbootemployee.entity.Company;
import com.thoughtworks.springbootemployee.service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/companies")
public class CompanyController {

    @Autowired
    CompanyService companyService;

    @GetMapping
    public List<Company> getALLCompanies() {
        return companyService.getALLCompanies();
    }

    @DeleteMapping(path = "/{id}")
    public void deleteCompany(@PathVariable Integer id) {
        companyService.deleteCompany(id);
    }

    @PutMapping(path = "/{id}")
    public void updateCompany(@PathVariable Integer id, @RequestBody Company company) {
        companyService.getCompanyById(id);
        companyService.updateCompany(company);
    }


}