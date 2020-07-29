package com.thoughtworks.springbootemployee.service.impl;

import com.thoughtworks.springbootemployee.Repository.EmployeeRepository;
import com.thoughtworks.springbootemployee.entity.Employee;
import com.thoughtworks.springbootemployee.exception.EmployeeNotFoundException;
import com.thoughtworks.springbootemployee.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    @Autowired
    private EmployeeRepository employeeRepository;

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
        getAllEmployee().remove(getAllEmployee()
                        .stream()
                        .filter(e -> e.getId() == id)
                        .findFirst()
                        .orElseThrow(EmployeeNotFoundException::new));
    }

}
