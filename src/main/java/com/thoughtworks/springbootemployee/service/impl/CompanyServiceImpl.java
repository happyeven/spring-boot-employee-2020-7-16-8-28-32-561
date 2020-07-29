package com.thoughtworks.springbootemployee.service.impl;

import com.thoughtworks.springbootemployee.Repository.CompanyRepository;
import com.thoughtworks.springbootemployee.entity.Company;
import com.thoughtworks.springbootemployee.entity.Employee;
import com.thoughtworks.springbootemployee.exception.CompanyNotFoundException;
import com.thoughtworks.springbootemployee.service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Service
public class CompanyServiceImpl implements CompanyService {

    @Autowired
    CompanyRepository companyRepository;

    @Override
    public Company getCompanyById(Integer id) {
        return companyRepository.findById(id).orElseThrow(CompanyNotFoundException::new);
    }

    @Override
    public List<Company> getALLCompanies() {
        return companyRepository.findAll();
    }

    @Override
    public void deleteCompany(Integer id) {
        if (companyRepository.findById(id).orElseThrow(CompanyNotFoundException::new)!=null){
            companyRepository.deleteById(id);
        }
    }

    @Override
    public void updateCompany(Company company) {
        companyRepository.save(company);
    }

    @Override
    public void addCompany(Company company) {
        companyRepository.save(company);
    }

    @Override
    public List<Employee> getEmployeeFromCompany(Integer id) {
        companyRepository.findById(id).orElseThrow(CompanyNotFoundException::new);
        return companyRepository.findById(id).get().getEmployeeList();
    }
}
