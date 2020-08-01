package com.thoughtworks.springbootemployee.service.impl;

import com.thoughtworks.springbootemployee.Repository.CompanyRepository;
import com.thoughtworks.springbootemployee.entity.Company;
import com.thoughtworks.springbootemployee.entity.Employee;
import com.thoughtworks.springbootemployee.exception.CompanyNotFoundException;
import com.thoughtworks.springbootemployee.service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

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
    public void updateCompany(Company company,Integer id) {
        Company findCompany=getCompanyById(id);
        findCompany.setName(company.getName());
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

    @Override
    public Page<Company> getAllCompany(Pageable pageable) {
        return companyRepository.findAll(pageable);
    }
}
