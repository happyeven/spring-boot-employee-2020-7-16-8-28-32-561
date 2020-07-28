package com.thoughtworks.springbootemployee.controller;
import com.thoughtworks.springbootemployee.entity.Company;
import com.thoughtworks.springbootemployee.entity.Employee;
import com.thoughtworks.springbootemployee.service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CompanyController {
    @Autowired
    CompanyService companyService;

    @PostMapping(path = "/companies")
    public void addCompany(@RequestBody Company company) {
        companyService.addCompany(company);
    }

    @GetMapping(path = "/companies")
    public List<Company> getCompany(@RequestParam(required = false,defaultValue = "0") Integer page, @RequestParam(required = false,defaultValue = "0")Integer pageSize) {
        if (page == 0 && pageSize == 0) {
            return companyService.getALLCompany();
        }
        return companyService.getCompanyInPages(page, pageSize);
    }

    @GetMapping(path = "/companies/{id}")
    public Company getCompany(@PathVariable int id) {
        return companyService.getCompanyById(id);
    }

    @DeleteMapping(path = "/companies/{id}")
    public void deleteCompany(@PathVariable int id) {
        companyService.deleteCompanyEmployeeById(id);
    }

    @PutMapping(path = "/companies")
    public void updateCompany(@RequestBody Company company) {
        companyService.updateCompany(company);
    }

    @GetMapping(path = "/companies/{id}/employees")
    public List<Employee> getEmployeeFromCompany(@PathVariable int id) {
        return companyService.getEmployeeFromCompany(id);
    }


//    @GetMapping(path = "/companies?page={page}&pageSize={pageSize}")
//    public List<Company> getCompanyInPage(@PathVariable int page, int pageSize) {
//        if (page == 0 && pageSize == 0) {
//            return companyService.getALLCompany();
//        }
//        return companyService.getCompanyInPages(page, pageSize);
//    }
}