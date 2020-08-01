package com.thoughtworks.springbootemployee.controller;



import com.thoughtworks.springbootemployee.Repository.CompanyRepository;
import com.thoughtworks.springbootemployee.dto.CompanyRequestDTO;
import com.thoughtworks.springbootemployee.entity.Company;
import com.thoughtworks.springbootemployee.entity.Employee;
import com.thoughtworks.springbootemployee.mapper.CompanyMapper;
import com.thoughtworks.springbootemployee.service.CompanyService;
import com.thoughtworks.springbootemployee.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/companies")
public class CompanyController {

    @Autowired
    CompanyService companyService;

    @Autowired
    EmployeeService employeeService;

    @Autowired
    CompanyRepository companyRepository;


    @DeleteMapping(path = "/{id}")
    public void deleteCompany(@PathVariable Integer id) {
        companyService.deleteCompany(id);
    }

    @PutMapping(path = "/{id}")
    public void updateCompany(@PathVariable Integer id, @RequestBody Company company) {
        companyService.updateCompany(company, id);
    }

    @PostMapping
    public void addCompany(@RequestBody CompanyRequestDTO company) {
        List<Integer> employees = company.getEmployeeIdList();
        List<Employee> employeeList =new ArrayList<>();
        for (Integer employee : employees) {
            employeeList.add(employeeService.findEmployeeById(employee));
        }
        Company saveCompany = CompanyMapper.companyCompanyRequestDTOtoCompany(company,employeeList);
        companyService.addCompany(saveCompany);
    }


    @GetMapping("/{id}/employees")
    public List<Employee> getEmployeeFromCompany(@PathVariable Integer id) {
        return companyService.getEmployeeFromCompany(id);
    }

    @GetMapping
    public Page<Company> getAllCompanyByPaged(@PageableDefault Pageable pageable, @RequestParam(defaultValue = "false") boolean unpaged) {
        if (unpaged) {
            return companyService.getAllCompany(Pageable.unpaged());
        }
        return companyService.getAllCompany(pageable);
    }

}