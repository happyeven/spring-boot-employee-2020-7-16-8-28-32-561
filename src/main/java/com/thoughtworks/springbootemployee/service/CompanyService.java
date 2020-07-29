package com.thoughtworks.springbootemployee.service;

import com.thoughtworks.springbootemployee.entity.Company;

public interface CompanyService {
    Company getCompanyById(Integer id);
}
