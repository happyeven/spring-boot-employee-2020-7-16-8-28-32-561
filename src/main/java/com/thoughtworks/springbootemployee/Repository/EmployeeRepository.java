package com.thoughtworks.springbootemployee.Repository;

import com.thoughtworks.springbootemployee.entity.Employee;
import org.springframework.stereotype.Repository;

import java.util.List;


public interface EmployeeRepository {
    List<Employee> findAll();
}
