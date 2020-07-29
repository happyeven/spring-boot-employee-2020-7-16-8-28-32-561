package com.thoughtworks.springbootemployee.Repository;

import com.thoughtworks.springbootemployee.entity.Company;
import org.springframework.stereotype.Repository;

import java.util.List;


public interface CompanyRepository {
    List<Company> findAll();
}
