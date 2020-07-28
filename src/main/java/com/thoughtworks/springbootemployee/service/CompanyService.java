package com.thoughtworks.springbootemployee.service;

import com.thoughtworks.springbootemployee.entity.Company;
import com.thoughtworks.springbootemployee.entity.Employee;

import java.util.List;

public interface CompanyService {
    List<Company> getALLCompany();
    void addCompany(Company company);
    Company getCompanyById(int id);
    void deleteCompanyEmployeeById(int id);
    void updateCompany(Company company);
    List<Employee> getEmployeeFromCompany(int id);
    List<Company> getCompanyInPages(Integer page, Integer pageSize);
}
