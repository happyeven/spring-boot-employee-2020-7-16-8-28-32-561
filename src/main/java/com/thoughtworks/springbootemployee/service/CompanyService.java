package com.thoughtworks.springbootemployee.service;

import com.thoughtworks.springbootemployee.entity.Company;

import java.util.List;

public interface CompanyService {
    Company getCompanyById(Integer id);
    List<Company> getALLCompanies();
    void deleteCompany(Integer id);
    void updateCompany(Company company);
    void addCompany(Company company);
}
