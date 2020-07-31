package com.thoughtworks.springbootemployee.service;

import com.thoughtworks.springbootemployee.entity.Company;
import com.thoughtworks.springbootemployee.entity.Employee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface CompanyService {
    Company getCompanyById(Integer id);
    List<Company> getALLCompanies();
    void deleteCompany(Integer id);
    void updateCompany(Company company,Integer id);
    void addCompany(Company company);
    List<Employee> getEmployeeFromCompany(Integer id);
    Page<Company> getAllEmployee(Pageable pageable);
}
