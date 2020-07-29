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

    @Override
    public Company getCompanyById(int id) {
        return companyList.stream()
                .filter(e -> e.getId() == id)
                .findFirst()
                .get();
    }

    @Override
    public void deleteCompanyEmployeeById(int id) {
        companyList.stream()
                .filter(e -> e.getId() == id)
                .findFirst()
                .get()
                .deleteAllEmployee();
    }

    @Override
    public void updateCompany(Company companyDTO) {
        Company company = companyList.stream()
                .filter(e -> e.getId() == companyDTO.getId())
                .findFirst()
                .get();
        company.setName(companyDTO.getName());
        company.setEmployeeList(companyDTO.getEmployeeList());
    }

    @Override
    public List<Employee> getEmployeeFromCompany(int id) {
        return companyList.stream()
                .filter(e -> e.getId() == id)
                .findFirst()
                .get()
                .getEmployeeList();
    }

    @Override
    public List<Company> getCompanyInPages(Integer page, Integer pageSize) {
        int startIndex = page * pageSize - pageSize;
        if (companyList.size() <= startIndex) {
            return null;
        }
        int endIndex = page * pageSize;
        if (companyList.size() < endIndex) {
            return companyList.subList(startIndex, companyList.size());
        }
        return companyList.subList(startIndex, endIndex);
    }
}
