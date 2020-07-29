package com.thoughtworks.springbootemployee.service.impl;

import com.thoughtworks.springbootemployee.Repository.CompanyRepository;
import com.thoughtworks.springbootemployee.Repository.EmployeeRepository;
import com.thoughtworks.springbootemployee.dto.EmployeeRequestDTO;
import com.thoughtworks.springbootemployee.entity.Company;
import com.thoughtworks.springbootemployee.entity.Employee;
import com.thoughtworks.springbootemployee.exception.EmployeeNotFoundException;
import com.thoughtworks.springbootemployee.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private CompanyRepository companyRepository;

    public List<Employee> getAllEmployee() {
        return employeeRepository.findAll();
    }

    @Override
    public Employee findEmployeeById(int id) {
        return employeeRepository.findById(id).orElseThrow(EmployeeNotFoundException::new);
    }

    @Override
    public Page<Employee> getAllEmployee(Pageable pageable) {
        return employeeRepository.findAll(pageable);
    }

    @Override
    public void deleteEmployee(int id) {
        findEmployeeById(id);
        employeeRepository.deleteById(id);
    }

    @Override
    public void updateEmployee(EmployeeRequestDTO employeeRequestDTO) {
        findEmployeeById(employeeRequestDTO.getId());
        Employee employee = employeeRequestDTO.toEntity();
        employee.setCompany(companyRepository.findById(employeeRequestDTO.getCompanyId()).orElse(null));
        employeeRepository.save(employee);
    }

    @Override
    public List<Employee> findEmployeeByGender(String gender) {
        return employeeRepository.findAll()
                .stream()
                .filter(e -> gender.equals(e.getGender()))
                .collect(Collectors.toList());
    }

    @Override
    public void addEmployee(EmployeeRequestDTO employeeRequestDTO) {
        Employee employee = employeeRequestDTO.toEntity();
        employee.setCompany(companyRepository.findById(employeeRequestDTO.getCompanyId()).orElse(null));
        employeeRepository.save(employee);
    }

}
