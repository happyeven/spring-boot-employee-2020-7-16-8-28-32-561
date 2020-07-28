package com.thoughtworks.springbootemployee.service.impl;

import com.thoughtworks.springbootemployee.entity.Company;
import com.thoughtworks.springbootemployee.entity.Employee;
import com.thoughtworks.springbootemployee.service.CompanyService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CompanyServiceImpl implements CompanyService {

    List<Company> companyList = new ArrayList<>();

    @Override
    public List<Company> getALLCompany() {
        return companyList;
    }

    @Override
    public void addCompany(Company company) {
        this.companyList.add(company);
    }



}
